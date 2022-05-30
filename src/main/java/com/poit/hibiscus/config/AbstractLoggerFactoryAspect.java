package com.poit.hibiscus.config;

import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.CurrencyType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.math.BigDecimal;

public abstract class AbstractLoggerFactoryAspect {

    public static final String ACCOUNT_TRANSACTION = "@annotation(com.poit.hibiscus.config.Transaction) && args(fromAccountId, toAccountNumber, amount)";
    public static final String CARD_TRANSACTION = "@annotation(com.poit.hibiscus.config.Transaction) && args(fromCardId, toCardNumber, amount)";

    public abstract void accountTransactionResolver(Long fromAccountId, String toAccountNumber, BigDecimal amount);

    public abstract void cardTransactionResolver(Long fromCardId, String toCardNumber, BigDecimal amount);

    public abstract static class AbstractLoggerOperation {
        public abstract void insert(Long fromAccountId, String toAccountNumber, BigDecimal amount);
    }
}
