package com.speedment.beacon;

import static com.speedment.beacon.Logger.Severity.ERROR;
import static com.speedment.beacon.Logger.Severity.INFO;
import com.speedment.beacon.resource.Resource;
import com.speedment.beacon.resource.Resources;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon.Beacon;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon_property.BeaconProperty;
import com.speedment.beacon.speedment_stat.db0.speedment_stat.beacon_property_key.BeaconPropertyKey;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.joining;

// select * from beacon as b, beacon_property as bp, beacon_property_key as bpk where (bp.beacon=b.id) and (bp.key=bpk.id);
//select b.id, b.created,b.ipAddress, bpk.key, bp.value from beacon as b, beacon_property as bp, beacon_property_key as bpk where (bp.beacon=b.id) and (bp.key=bpk.id);
// select b.id, b.created,b.ipAddress, bpk.key, bp.value from beacon as b, beacon_property as bp, beacon_property_key as bpk where (bp.beacon=b.id) and (bp.key=bpk.id) order by b.id desc, bpk.id;
/**
 *
 * @author pemi
 */
public class BeaconServer extends NanoHTTPD {

    private static final int POOL_SIZE = 128;
    
    private final Map<String, BeaconPropertyKey> beaconPropertyKeys;
    private final ExecutorService pool;
    

    public BeaconServer() {
        super(8081);
        beaconPropertyKeys = BeaconPropertyKey.stream().collect(Collectors.toMap(bpc -> bpc.getKey().toLowerCase(), Function.identity()));
        pool = Executors.newFixedThreadPool(POOL_SIZE);
    }

    @Override
    public Response serve(IHTTPSession session) {
        final Method method = session.getMethod();
        final String uri = session.getUri();
        final String command = uri.substring(uri.indexOf("/") + 1);
        final Map<String, String> params = session.getParms();

        final StringBuilder sb = new StringBuilder();
        sb
                .append(session.getHeaders().get("remote-addr"))
                .append(" ").append(method)
                .append(" '").append(uri).append("' ")
                .append(params.entrySet().stream().map(e -> "\"" + e.getKey() + "\" = \"" + e.getValue() + "\"")
                        .collect(joining(", ", "(", ")")))
                .append(" -> ");

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
                pool.execute(new LogToDb(session, params));
                break;
            case "one.gif":
                resp = Helper.success(Resources.ONE_GIF);
                break;
            default:
                resp = Helper.fail();
        }

        try {
            sb
                    .append(resp.getStatus().getDescription())
                    .append(" (")
                    .append(resp.getData().available())
                    .append(" bytes)");
            Logger.log(INFO, sb);
        } catch (IOException ex) {
            Logger.log(ERROR, ex.getMessage());
            ex.printStackTrace(System.err);
        }

        
        
        return resp;
    }

    private class LogToDb implements Runnable {

        private final IHTTPSession session;
        private final Map<String, String> params;

        public LogToDb(IHTTPSession session, Map<String, String> params) {
            this.session = session;
            this.params = params;
        }

        @Override
        public void run() {
            //Logger.log(Logger.Severity.DEBUG, "Thread: "+Thread.currentThread().getName());
            logToDb(session, params);
        }

    }

    private void logToDb(IHTTPSession session, Map<String, String> params) {

        final String ipAddress = session.getHeaders().get("remote-addr");
        final Optional<Beacon> oBeacon = Beacon.builder().setIpAddress(ipAddress).persist(/*MetadataUtil.toText(System.out::println)*/);

        if (oBeacon.isPresent()) {
            final Beacon beacon = oBeacon.get();

            // Copy from header
            Arrays.asList("referer", "user-agent").stream().forEach((key) -> {
                String value = session.getHeaders().get(key);
                if (value != null) {
                    Optional<BeaconProperty> oBeaconProperty = BeaconProperty.builder()
                            .setBeacon(beacon.getId())
                            .setKey(beaconPropertyKeys.get(key).getId())
                            .setValue(value)
                            .persist(/*MetadataUtil.toText(System.out::println)*/);
                }
            });

            // Copy from URL parameters
            Arrays.asList("site", "path", "comment", "version").stream().forEach((key) -> {
                String value = session.getParms().get(key);
                if (value != null) {
                    Optional<BeaconProperty> oBeaconProperty = BeaconProperty.builder()
                            .setBeacon(beacon.getId())
                            .setKey(beaconPropertyKeys.get(key).getId())
                            .setValue(value)
                            .persist(/*MetadataUtil.toText(System.out::println)*/);
                }
            });

            // Lookup IP-address
            try {
                InetAddress addr = InetAddress.getByName(ipAddress);
                String value = addr.getCanonicalHostName();
                final String key = "ip-address-name";
                Optional<BeaconProperty> oBeaconProperty = BeaconProperty.builder()
                        .setBeacon(beacon.getId())
                        .setKey(beaconPropertyKeys.get(key).getId())
                        .setValue(value)
                        .persist(/*MetadataUtil.toText(System.out::println)*/);
            } catch (UnknownHostException uhe) {
                // Ignore
            }

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
