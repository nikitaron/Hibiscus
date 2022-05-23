package com.poit.hibiscus.service;

import com.poit.hibiscus.entity.Transactions;

public interface TransactionsService {

    interface AccountTransactionService {
        void insert(Transactions.AccountTransaction accountTransaction);
    }

    interface CardTransactionService {
        void insert(Transactions.CardTransaction cardTransaction);
    }
}
