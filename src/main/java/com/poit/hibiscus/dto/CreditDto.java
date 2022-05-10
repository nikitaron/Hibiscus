package com.poit.hibiscus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.poit.hibiscus.entity.CurrencyType;
import com.poit.hibiscus.entity.Passport;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private LocalDateTime issuanceDate;

    private BigDecimal amount;

    @JsonProperty(access = Access.READ_ONLY)
    private Passport passport;

    private CurrencyType currencyType;
}
