package com.speedment.beacon;

import java.sql.Timestamp;
import java.util.Objects;

/**
 *
 * @author pemi
 */
public class Logger {

    public enum Severity {

        INFO("INFO "), DEBUG("DEBUG"), WARN("WARN "), ERROR("ERROR"), FATAL("FATAL");

        private Severity(String text) {
            this.text = text;
        }

        private final String text;

        public String toText() {
            return text;
        }

    }

    public static void log(Severity severity, Object msg) {
        System.out.println(new Timestamp(System.currentTimeMillis()).toInstant() + " " + severity.toText() + " (" + Thread.currentThread().getName() + ") " + Objects.toString(msg));
    }

}
