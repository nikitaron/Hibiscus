package com.poit.hibiscus.dto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionsDto {

    public record CardTransactionDto(Long fromCardId,
                                     String toCardNumber,
                                     BigDecimal amount) {
    }

    public record AccountTransactionDto(Long fromAccountId,
                                        String toAccountNumber,
                                        BigDecimal amount) {
    }
}