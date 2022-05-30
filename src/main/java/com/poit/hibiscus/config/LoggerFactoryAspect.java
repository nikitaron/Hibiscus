package com.poit.hibiscus.config;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerFactoryAspect extends AbstractLoggerFactoryAspect {
    private final CardLoggerOperation cardLoggerOperation;
    private final AccountLoggerOperation accountLoggerOperation;

    @Override
    @AfterReturning(
            pointcut = ACCOUNT_TRANSACTION)
    public void accountTransactionResolver(Long fromAccountId, String toAccountNumber, BigDecimal amount) {
        accountLoggerOperation.insert(fromAccountId, toAccountNumber, amount);
    }

    @Override
    @AfterReturning(
            pointcut = CARD_TRANSACTION)
    public void cardTransactionResolver(Long fromCardId, String toCardNumber, BigDecimal amount) {
        cardLoggerOperation.insert(fromCardId, toCardNumber, amount);
    }
}
