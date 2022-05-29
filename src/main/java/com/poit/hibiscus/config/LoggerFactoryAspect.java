package com.poit.hibiscus.config;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class LoggerFactoryAspect extends AbstractLoggerFactoryAspect {
    private final CardLoggerOperation cardLoggerOperation;
    private final AccountLoggerOperation accountLoggerOperation;

    @Override
    @AfterReturning(
            pointcut = LOGGING, returning = "o")
    public void loggingResolver(Object o) {
        var transactionType = getTransactionType(o.getClass());

    }
}
