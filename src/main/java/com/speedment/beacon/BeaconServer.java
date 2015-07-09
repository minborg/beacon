package com.speedment.beacon;

import com.speedment.beacon.resource.Resource;
import com.speedment.beacon.resource.Resources;
import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import java.io.IOException;
import java.util.Map;
import static java.util.stream.Collectors.joining;

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
        final Method method = session.getMethod();
        final String uri = session.getUri();
        final String command = uri.substring(uri.indexOf("/") + 1);

        final Map<String, String> params = session.getParms();

        System.out.print(method + " '" + uri + "' "
                + params.entrySet().stream()
                .map(e -> "\"" + e.getKey() + "\" = \"" + e.getValue() + "\"")
                .collect(joining(", ", "(", ")"))
                + " -> "
        );

        final Response resp;
        
        switch (command) {
            case "Cats"     : resp = Helper.success(Resources.CATS_JPG);  break;
            case "Mario"    : resp = Helper.success(Resources.MARIO_PNG); break;
            case "Beacon"   : resp = Helper.success(Resources.ONE_PNG);   break;
            case "one.gif"  : resp = Helper.success(Resources.ONE_GIF);   break;
            default         : resp = Helper.fail();
        }
        
        try {
            System.out.println(resp.getStatus().getDescription() + " (" + resp.getData().available() + " bytes)");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
        return resp;
    }
    
    private static class Helper {
        
        private Helper() {}
        
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