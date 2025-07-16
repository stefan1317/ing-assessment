package com.example.ing.exceptions;

public class RecordCannotBeNull extends RuntimeException {
    public RecordCannotBeNull(String message) {
        super(message);
    }
}
