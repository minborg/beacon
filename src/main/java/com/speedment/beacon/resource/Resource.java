package com.speedment.beacon.resource;

import com.speedment.beacon.resource.mime.MimeType;
import java.io.InputStream;

/**
 *
 * @author pemi
 */
public interface Resource {
    MimeType getMimeType();
    InputStream newInputStream();
}