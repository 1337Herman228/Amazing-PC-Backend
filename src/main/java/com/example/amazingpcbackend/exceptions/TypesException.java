package com.example.amazingpcbackend.exceptions;

public class TypesException extends Exception {
    public TypesException(String message) {
        super(message);
    }

    public TypesException(String message, Throwable cause) {
        super(message, cause);
    }

    public TypesException(Throwable cause) {
        super(cause);
    }
}
