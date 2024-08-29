package com.example.amazingpcbackend.exceptions;

public class PartitionsException extends Exception {
    public PartitionsException(String message) {
        super(message);
    }

    public PartitionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public PartitionsException(Throwable cause) {
        super(cause);
    }
}