package com.speedment.beacon.resource.mime;

/**
 *
 * @author pemi
 */
public enum StandardMimeTypes implements MimeType {

    PNG("image/png"),
    JPG("image/jpeg"),
    GIF("image/gif"),
    HTML("text/html");

    private final String text;

    private StandardMimeTypes(String text) {
        this.text = text;
    }

    @Override
    public String toText() {
        return text;
    }

}
