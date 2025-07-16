package com.example.ing.exceptions;

public class RecordCannotBeNullException extends RuntimeException {
    public RecordCannotBeNullException(String message) {
        super(message);
    }
}
