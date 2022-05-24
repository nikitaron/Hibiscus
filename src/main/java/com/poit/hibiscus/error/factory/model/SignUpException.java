package com.poit.hibiscus.error.factory.model;

public class SignUpException extends RuntimeException {

    public SignUpException(String message) {
        super(message);
        System.out.println("DASDA");
    }
}
