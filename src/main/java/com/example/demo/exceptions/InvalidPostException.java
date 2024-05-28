package com.example.demo.exceptions;

public class InvalidPostException extends Exception {
    public InvalidPostException(String message) {
        super(message);
    }
}