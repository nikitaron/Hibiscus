package com.poit.hibiscus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poit.hibiscus.entity.CurrencyType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime transactionTime;

    private String toAccount;

    private BigDecimal amount;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CurrencyType currencyType;
}
