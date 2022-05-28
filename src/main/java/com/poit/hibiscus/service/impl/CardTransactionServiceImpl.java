package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.entity.Transactions;
import com.poit.hibiscus.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardTransactionServiceImpl implements TransactionsService.CardTransactionService {
    @Override
    public void insert(Transactions.CardTransaction cardTransaction) {

    }
}
