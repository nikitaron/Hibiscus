package com.poit.hibiscus.error.factory.api.error.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.poit.hibiscus.error.factory.model.ErrorType;
import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Value
@Builder
public class ErrorResponse {
    String message;

    @JsonProperty(value = "type")
    ErrorType errorType;

    @JsonIgnore
    HttpStatus httpStatus;

    Instant timestamp = Instant.now();
}
