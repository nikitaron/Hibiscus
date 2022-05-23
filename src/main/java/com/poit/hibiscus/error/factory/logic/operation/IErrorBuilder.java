package com.poit.hibiscus.error.factory.logic.operation;

import com.poit.hibiscus.error.factory.api.error.dto.ErrorResponse;

public interface IErrorBuilder<T extends RuntimeException> {

    ErrorResponse build(T e) throws NoSuchMethodException;
}
