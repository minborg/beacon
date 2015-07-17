package com.speedment.beacon;

import com.speedment.beacon.speedment_stat.SpeedmentStatApplication;
import com.speedment.core.runtime.SpeedmentApplicationLifecycle;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;

/**
 *
 * @author pemi
 */
public class Main {

    public static void main(String[] args) {

        System.out.println(SpeedmentApplicationLifecycle.class.getPackage().getImplementationVersion());
        
        // Fixa så man kan göra  with(Hare.class,
        final SpeedmentStatApplication app = new SpeedmentStatApplication()
                //                .withUsername("tryggve")
                //                .withPassword("secret123")
                //                .withIpAddress("some_other_host")
                //                .withPort(1234)
                //                .with(Dbms.class, (Dbms d) -> d.setIpAddress("localhost12345"))
                //                .with(Dbms.class, "speedment_stat.db0", d -> d.setUsername("Tryggve2"))
                .start();

        //Dbms dbms = Platform.get().get(ProjectComponent.class).getProject().traverseOver(Dbms.class).findAny().get();
//        System.out.println("username : "+dbms.getUsername());
//        System.out.println("password : "+dbms.getPassword());
//        System.out.println("ipAddress: "+dbms.getIpAddress());
//        System.out.println("port     : "+dbms.getPort());
        try {
            NanoHTTPD server = new BeaconServer();
            server.start();
            Logger.log(Logger.Severity.INFO, "Server " + server + " started.");
            for (;;) {
                try {
                    Thread.sleep(60 * 60 * 1000);
                } catch (InterruptedException ie) {
                    Logger.log(Logger.Severity.INFO, "Server " + server + " is alive.");
                }
            }
            //ServerRunner.run(BeaconServer.class);
        } catch (IOException ioe) {
            Logger.log(Logger.Severity.FATAL, ioe.getMessage());
            ioe.printStackTrace(System.err);
        } finally {
            app.stop();
        }
    }

}
