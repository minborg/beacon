package com.speedment.beacon;

import com.speedment.Speedment;
import com.speedment.beacon.speedment_stat.SpeedmentStatApplication;
import com.speedment.internal.logging.Logger;
import com.speedment.internal.logging.LoggerManager;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;

/**
 *
 * @author pemi
 */
public class Main {

    private static final Logger LOGGER = LoggerManager.getLogger(Main.class);

    public static void main(String[] args) {

        LOGGER.info(Main.class.getName() + " start at %d...", System.currentTimeMillis());

        final Speedment speedment = new SpeedmentStatApplication()
                .withPassword("UASMGWRCYAd7nXfv75JnARq6IVPl0gFUoRJWc6J0zCnjFNawH0XHeYqeSGvInvXlNs5neyjSnHVKwgjX1OKhaxqplGstxdD47LgdjPIcs8cPZjNwFNr3bVkkmqCrIDM6")
                .build();

        try {
            NanoHTTPD server = new BeaconServer(speedment);
            server.start();
            LOGGER.info("Server " + server + " started.");
            for (;;) {
                try {
                    Thread.sleep(60 * 60 * 1000);
                } catch (InterruptedException ie) {
                    LOGGER.info("Server " + server + " is alive.");
                }
            }
            //ServerRunner.run(BeaconServer.class);
        } catch (IOException ioe) {
            LOGGER.fatal(ioe, ioe.getMessage());
            ioe.printStackTrace(System.err);
        } finally {
            speedment.stop();
        }
    }

}
