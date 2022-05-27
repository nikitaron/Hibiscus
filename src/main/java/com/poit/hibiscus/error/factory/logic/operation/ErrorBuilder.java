package com.poit.hibiscus.error.factory.logic.operation;

import com.poit.hibiscus.error.factory.api.error.dto.ErrorResponse;
import com.poit.hibiscus.error.factory.configuration.HandleError;
import com.poit.hibiscus.error.factory.logic.resolver.ErrorResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class ErrorBuilder<T extends RuntimeException> implements IErrorBuilder<T> {
    private final ErrorResolver errorResolver;

    @Override
    public ErrorResponse build(T e) {
        var stackTraceElement = e.getStackTrace()[0];
        try {
            var clazz = Class.forName(stackTraceElement.getClassName());

            var type = Arrays.stream(clazz.getDeclaredMethods())
                    .filter(method -> method.toString().contains(stackTraceElement.getMethodName()))
                    .findFirst()
                    .map(method -> method.getAnnotation(HandleError.class).type())
                    .orElseThrow(RuntimeException::new);

            var status = errorResolver.resolve(type);

            return ErrorResponse.builder()
                    .errorType(type)
                    .message(e.getMessage())
                    .httpStatus(status)
                    .build();
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException("Class or method is not found");
        }
    }
}
