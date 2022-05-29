package com.poit.hibiscus.config;

import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.CurrencyType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.math.BigDecimal;

public abstract class AbstractLoggerFactoryAspect {

    public static final String POINTCUT = "loggingPointcut()";
    public static final String LOGGING = "@annotation(com.poit.hibiscus.config.Logging)";

    public abstract void loggingResolver(Object o);

    protected TransactionType getTransactionType(Class<?> clazz) {
        return TransactionType.ACCOUNT_TRANSFER;
    }

    public abstract static class AbstractLoggerOperation {
        public abstract void insert();
    }
}
