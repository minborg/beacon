package com.speedment.beacon.resource.content;

import com.speedment.beacon.resource.DefaultResource;
import com.speedment.beacon.resource.mime.StandardMimeTypes;

/**
 *
 * @author pemi
 */
public class OnePng extends DefaultResource {

    public OnePng() {
        super(StandardMimeTypes.PNG, "one.png");
    }

//    public OnePng() {
//    }
//
//    @Override
//    public MimeType getMimeType() {
//        return StandardMimeTypes.PNG;
//    }
//
//    @Override
//    public InputStream newInputStream() {
//        return OnePng.class.getResourceAsStream("one.png");
//    }
}
