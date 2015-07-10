package com.speedment.beacon;

import static com.speedment.beacon.Logger.Severity.ERROR;
import com.speedment.beacon.resource.Resource;
import com.speedment.beacon.resource.Resources;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon.Beacon;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon_property.BeaconProperty;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon_property_key.BeaconPropertyKey;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static java.util.stream.Collectors.joining;


// select * from beacon as b, beacon_property as bp, beacon_property_key as bpk where (bp.beacon=b.id) and (bp.key=bpk.id);

/**
 *
 * @author pemi
 */
public class BeaconServer extends NanoHTTPD {

    private final Map<String, BeaconPropertyKey> beaconPropertyKeys;

    public BeaconServer() {
        super(8081);
        //beaconPropertyKeys = BeaconPropertyKey.stream().collect(Collectors.toMap(BeaconPropertyKey::getKey, Function.identity()));
        beaconPropertyKeys = new HashMap<>();
    }

    @Override
    public Response serve(IHTTPSession session) {
        final Map<String, String> files = new HashMap<>();
        final Method method = session.getMethod();
        final String uri = session.getUri();
        final String command = uri.substring(uri.indexOf("/") + 1);

        if (Method.PUT.equals(method)
                || Method.POST.equals(method)) {

            try {
                session.parseBody(files);
            } catch (IOException ex) {
                return new Response(Response.Status.INTERNAL_ERROR, MIME_PLAINTEXT,
                        "SERVER INTERNAL ERROR: IOException: " + ex.getMessage()
                );
            } catch (ResponseException ex) {
                return new Response(ex.getStatus(), MIME_PLAINTEXT, ex.getMessage());
            }
        }

        final Map<String, String> params = session.getParms();

        System.out.print(method + " '" + uri + "' "
                + params.entrySet().stream()
                .map(e -> "\"" + e.getKey() + "\" = \"" + e.getValue() + "\"")
                .collect(joining(", ", "(", ")"))
                + " -> "
        );

        final Response resp;

        switch (command) {
            case "Cats":
                resp = Helper.success(Resources.CATS_JPG);
                break;
            case "Mario":
                resp = Helper.success(Resources.MARIO_PNG);
                break;
            case "Beacon":
                resp = Helper.success(Resources.ONE_PNG);
                logToDb(session, params);
                break;
            case "one.gif":
                resp = Helper.success(Resources.ONE_GIF);
                break;
            default:
                resp = Helper.fail();
        }

        return resp;
    }

    private void logToDb(IHTTPSession session, Map<String, String> params) {
        // In a separate Thread

        final String ipAddress = session.getHeaders().get("remote-addr");
        final Optional<Beacon> oBeacon = Beacon.builder().setIpAddress(ipAddress).persist();
        
        if (oBeacon.isPresent()) {
            final Beacon beacon = oBeacon.get();
            
            // Copy from header
            Arrays.asList("Referer", "User-Agent").stream().forEach((key) -> {
                String value = session.getHeaders().get(key);
                Optional<BeaconProperty> oBeaconProperty = BeaconProperty.builder()
                        .setBeacon(beacon.getId())
                        .setKey(beaconPropertyKeys.get(key).getId())
                        .setValue(value)
                        .persist();
            });
        } else {
            Logger.log(ERROR, "Unable to create Beacon");
        }
    }

    private static class Helper {

        private Helper() {
        }

        public static Response fail() {
            return response(Resources.NOT_FOUND_404, Status.NOT_FOUND);
        }

        public static Response success(Resource resource) {
            return response(resource, Status.OK);
        }

        private static Response response(Resource resource, Status status) {
            final NanoHTTPD.Response response = new NanoHTTPD.Response(
                    status,
                    resource.getMimeType().toText(),
                    resource.newInputStream()
            );

            response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.addHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.addHeader("Expires", "0"); // Proxies

            return response;
        }
    }
}
