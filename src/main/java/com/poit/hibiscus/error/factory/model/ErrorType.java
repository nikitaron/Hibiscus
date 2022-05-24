package com.poit.hibiscus.error.factory.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorType {
    BUSINESS("Business"),
    VALIDATION("Validation"),
    SECURITY("Security");

    private final String type;
}
