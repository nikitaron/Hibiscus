package com.poit.hibiscus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String pin;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String number;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String cvv;

    private Timestamp expirationTime;
}
