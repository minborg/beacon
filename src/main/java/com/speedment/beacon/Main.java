package com.speedment.beacon;

import com.speedment.beacon.speedment_stat.SpeedmentStatApplication;
import fi.iki.elonen.ServerRunner;

/**
 *
 * @author pemi
 */
public class Main {

    public static void main(String[] args) {

        new SpeedmentStatApplication().start();
        try {

            ServerRunner.run(BeaconServer.class);
        } finally {

        }
    }

}
