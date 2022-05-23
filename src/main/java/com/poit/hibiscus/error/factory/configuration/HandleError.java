package com.poit.hibiscus.error.factory.configuration;

import com.poit.hibiscus.error.factory.model.ErrorType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static com.poit.hibiscus.error.factory.model.ErrorType.VALIDATION;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface HandleError {
    ErrorType type() default VALIDATION;
}
