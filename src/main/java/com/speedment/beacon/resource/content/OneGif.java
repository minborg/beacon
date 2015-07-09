package com.speedment.beacon.resource.content;

import com.speedment.beacon.resource.DefaultResource;
import com.speedment.beacon.resource.mime.StandardMimeTypes;

/**
 *
 * @author Emil Forslund
 */
public class OneGif extends DefaultResource {
    public OneGif() {
        super (StandardMimeTypes.GIF, "one.gif");
    }
}
