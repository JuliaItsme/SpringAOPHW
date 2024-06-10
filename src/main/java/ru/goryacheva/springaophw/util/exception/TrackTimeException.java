package ru.goryacheva.springaophw.util.exception;

public class TrackTimeException extends RuntimeException{

    public TrackTimeException(String message) {
        super(message);
    }

    public TrackTimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
