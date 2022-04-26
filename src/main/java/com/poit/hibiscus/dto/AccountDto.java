package com.poit.hibiscus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poit.hibiscus.entity.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BigDecimal money;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    private String iban;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String number;

    private CurrencyType currencyType;
}
