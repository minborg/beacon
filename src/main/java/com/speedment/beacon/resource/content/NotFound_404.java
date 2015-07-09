package com.speedment.beacon.resource.content;

import com.speedment.beacon.resource.DefaultResource;
import com.speedment.beacon.resource.mime.StandardMimeTypes;

/**
 *
 * @author pemi
 */
public class NotFound_404 extends DefaultResource {

    public NotFound_404() {
        super(StandardMimeTypes.HTML, "404.html");
    }

}
