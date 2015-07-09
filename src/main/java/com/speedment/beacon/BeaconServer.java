package com.speedment.beacon;

import com.speedment.beacon.resource.Resource;
import com.speedment.beacon.resource.Resources;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import static java.util.Optional.ofNullable;
import java.util.stream.Collectors;

/**
 *
 * @author pemi
 */
public class BeaconServer extends NanoHTTPD {

    public BeaconServer() {
        super(8081);
    }

    @Override
    public Response serve(IHTTPSession session) {
        final Map<String, String> files = new HashMap<>();
        final NanoHTTPD.Method method = session.getMethod();
        final String uri = session.getUri();
        final String command = uri.substring(uri.indexOf("/") + 1);

        if (Method.PUT.equals(method) || Method.POST.equals(method)) {
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
                .map(e -> "\"" + e.getKey() + "\" = \"" + limitString(e.getValue()) + "\"")
                .collect(Collectors.joining(", ", "(", ")"))
                + " -> "
        );

        final Response resp;
        
        switch (command) {
            case "Cats"     : resp = response(Resources.CATS_JPG);  break;
            case "Mario"    : resp = response(Resources.MARIO_PNG); break;
            case "Beacon"   : resp = response(Resources.ONE_PNG);   break;
            case "One"      : resp = response(Resources.ONE_GIF);   break;
            default         : resp = response(Resources.NOT_FOUND_404);
        }
        
        try {
            System.out.println(resp.getStatus().getDescription() + " (" + resp.getData().available() + " bytes)");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        return resp;
    }

    private NanoHTTPD.Response response(Resource resource) {
        final NanoHTTPD.Response response = new NanoHTTPD.Response(
            Response.Status.OK, 
            resource.getMimeType().toText(), 
            resource.newInputStream()
        );
        
        response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.addHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.addHeader("Expires", "0"); // Proxies
        
        return response;
    }

    private long parseLong(Map<String, String> params, String command) {
        return parseOptional(params, command).map(s -> Long.parseLong(s)).orElse(-1L);
    }

    private Optional<Timestamp> parseTime(Map<String, String> params, String command) {
        return parseOptional(params, command).map(s -> Timestamp.valueOf(s.replaceAll("T", " ")));
    }

    private String parseString(Map<String, String> params, String command) {
        return parseOptional(params, command).orElse("");
    }

    private Optional<String> parseOptional(Map<String, String> params, String command) {
        return ofNullable(params.get(command)).map(s -> s.trim()).filter(p -> !p.isEmpty());
    }

    private String limitString(String s) {
        return limitString(s, 64);
    }

    private String limitString(String s, int len) {
        if (s.length() <= len) {
            return s;
        }
        return s.substring(0, len) + "...";
    }

}
