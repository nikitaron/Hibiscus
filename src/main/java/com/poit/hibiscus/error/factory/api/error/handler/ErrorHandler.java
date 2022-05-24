package com.poit.hibiscus.error.factory.api.error.handler;

import com.poit.hibiscus.error.factory.api.error.dto.ErrorResponse;
import com.poit.hibiscus.error.factory.logic.operation.IErrorBuilder;
import com.poit.hibiscus.error.factory.model.SignUpException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class ErrorHandler {
    private final IErrorBuilder<? super RuntimeException> errorBuilder;

    @ExceptionHandler(SignUpException.class)
    public ResponseEntity<ErrorResponse> handle(SignUpException e) throws NoSuchMethodException {
        var error = errorBuilder.build(e);

        return new ResponseEntity<>(error, error.getHttpStatus());
    }
}
