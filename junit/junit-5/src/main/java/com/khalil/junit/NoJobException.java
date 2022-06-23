package com.khalil.junit;

public class NoJobException extends RuntimeException {
    NoJobException(String message) {
        super(message);
    }
}