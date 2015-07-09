package com.speedment.beacon.resource;

import com.speedment.beacon.resource.content.CatsJpg;
import com.speedment.beacon.resource.content.MarioPng;
import com.speedment.beacon.resource.content.NotFound_404;
import com.speedment.beacon.resource.content.OnePng;

public class Resources {

    private Resources() {
    }

    public static final Resource ONE_PNG = new OnePng();
    public static final Resource NOT_FOUND_404 = new NotFound_404();
    public static final Resource CATS_JPG = new CatsJpg();
    public static final Resource MARIO_PNG = new MarioPng();

}
