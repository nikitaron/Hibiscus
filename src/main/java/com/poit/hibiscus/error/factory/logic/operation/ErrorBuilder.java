package com.poit.hibiscus.error.factory.logic.operation;

import com.poit.hibiscus.error.factory.api.error.dto.ErrorResponse;
import com.poit.hibiscus.error.factory.configuration.HandleError;
import com.poit.hibiscus.error.factory.logic.resolver.ErrorResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ErrorBuilder<T extends RuntimeException> implements IErrorBuilder<T> {
    private final ErrorResolver errorResolver;

    @Override
    public ErrorResponse build(T e) throws NoSuchMethodException {
        var stackTraceElement = e.getStackTrace()[0];

        try {
            var type =
                    Class.forName(stackTraceElement.getClassName())
                            .getMethod(stackTraceElement.getMethodName())
                            .getAnnotation(HandleError.class).type();

            var status = errorResolver.resolve(type);

            return ErrorResponse.builder()
                    .errorType(type)
                    .message(e.getMessage())
                    .httpStatus(status)
                    .build();
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException("Declared class not found");
        }
    }
}
