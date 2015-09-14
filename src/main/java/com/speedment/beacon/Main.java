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
        
        //Beacon b = null;
        //final Map<Long, Beacon> map = new ConcurrentHashMap<>();
        //Beacon.stream().forEach(h -> map.put(h.getId(), h));
        final Speedment speedment = new SpeedmentStatApplication()
                

                //.withPassword("beacon")

                //                .withUsername("tryggve")
                //                .withPassword("secret123")
                //                .withIpAddress("some_other_host")
                //                .withPort(1234)
                //                .with(Dbms.class, (Dbms d) -> d.setIpAddress("localhost12345"))
                //                .with(Dbms.class, "speedment_stat.db0", d -> d.setUsername("Tryggve2"))
                .build();

//        JsonFormatter<Beacon> jfa = JsonFormatter.allOf(Beacon.class);
//        JsonFormatter<Beacon> jfn = JsonFormatter.noneOf(Beacon.class);
//        JsonFormatter<Beacon> jf1 = JsonFormatter.of(Beacon.class, BeaconField.ID);
//        JsonFormatter<Beacon> jfc = JsonFormatter.noneOf(Beacon.class).put("id", b -> b.getId() + "Olle");
//
//        System.out.println(Beacon.stream().limit(10).map(b -> b.toJson(jfa)).collect(joining("\n")));
//        System.out.println(Beacon.stream().limit(10).map(b -> b.toJson(jfn)).collect(joining("\n")));
//        System.out.println(Beacon.stream().limit(10).map(b -> b.toJson(jf1)).collect(joining("\n")));
//        System.out.println(Beacon.stream().limit(10).map(b -> b.toJson(jfc)).collect(joining("\n")));
//        if (1 == 1) {
//            return;
//        }
        //Dbms dbms = Platform.get().get(ProjectComponent.class).getProject().traverseOver(Dbms.class).findAny().get();
//        System.out.println("username : "+dbms.getUsername());
//        System.out.println("password : "+dbms.getPassword());
//        System.out.println("ipAddress: "+dbms.getIpAddress());
//        System.out.println("port     : "+dbms.getPort());
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
