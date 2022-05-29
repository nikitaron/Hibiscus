package com.poit.hibiscus.config;

import com.poit.hibiscus.repository.adapter.AccountTransactionRepositoryAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class CardLoggerOperation extends AbstractLoggerFactoryAspect.AbstractLoggerOperation {
    private final AccountTransactionRepositoryAdapter adapter;

    @Override
    public void insert() {

    }
}