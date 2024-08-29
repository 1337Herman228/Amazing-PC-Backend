package com.example.amazingpcbackend.exceptions;

public class PartsException extends Exception {
    public PartsException(String message) {
        super(message);
    }

    public PartsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PartsException(Throwable cause) {
        super(cause);
    }
}
