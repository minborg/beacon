package com.speedment.beacon.resource;

import com.speedment.beacon.resource.content.OnePng;
import com.speedment.beacon.resource.mime.MimeType;
import java.io.InputStream;

/**
 *
 * @author pemi
 */
public class DefaultResource implements Resource {

    private final MimeType mimeType;
    private final String resourceName;

    public DefaultResource(MimeType mimeType, String resourceName) {
        this.mimeType = mimeType;
        this.resourceName = resourceName;
    }

    @Override
    public MimeType getMimeType() {
        return mimeType;
    }

    @Override
    public InputStream newInputStream() {
        return OnePng.class.getResourceAsStream(resourceName);
    }

}
