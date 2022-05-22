package com.poit.hibiscus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardTransactionWrapper {

    @JsonProperty("number")
    private String cardNumber;

    @JsonProperty("transactionDto")
    private TransactionDto transactionDto;


}
