package com.speedment.beacon.resource;

import com.speedment.beacon.resource.content.CatsJpg;
import com.speedment.beacon.resource.content.MarioPng;
import com.speedment.beacon.resource.content.NotFound_404;
import com.speedment.beacon.resource.content.OneGif;
import com.speedment.beacon.resource.content.OnePng;
import com.speedment.beacon.resource.mime.MimeType;
import java.io.InputStream;

public enum Resources implements Resource {
    
    ONE_PNG       (new OnePng()),
    ONE_GIF       (new OneGif()),
    NOT_FOUND_404 (new NotFound_404()),
    CATS_JPG      (new CatsJpg()),
    MARIO_PNG     (new MarioPng());
    
    private final Resource resource;

    private Resources(Resource res) {
        resource = res;
    }

    @Override
    public MimeType getMimeType() {
        return resource.getMimeType();
    }

    @Override
    public InputStream newInputStream() {
        return resource.newInputStream();
    }
}