package com.poit.hibiscus.error.factory.logic.resolver;

import com.poit.hibiscus.error.factory.model.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorResolver {

    public HttpStatus resolve(ErrorType errorType) {
        return switch (errorType) {
            case VALIDATION -> HttpStatus.BAD_REQUEST;
            case SECURITY -> HttpStatus.FORBIDDEN;
            case BUSINESS -> HttpStatus.UNPROCESSABLE_ENTITY;
        };
    }
}

