package com.poit.hibiscus.service.impl;

import com.google.gson.Gson;
import com.poit.hibiscus.api.domain.client.operation.CurrencyOperation;
import com.poit.hibiscus.config.Transaction;
import com.poit.hibiscus.error.factory.configuration.HandleError;
import com.poit.hibiscus.error.factory.model.TransactionDeniedException;
import com.poit.hibiscus.repository.AccountTransactionRepository;
import com.poit.hibiscus.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountTransactionServiceImpl implements TransactionsService.AccountTransactionService {
    private final CurrencyOperation currencyOperation;
    private final AccountTransactionRepository accountTransactionRepository;

    @Override
    @HandleError
    @Transaction
    public void insert(Long fromAccountId, String toAccountNumber, BigDecimal amount) throws InterruptedException {
        var currency = currencyOperation.activate();

        var quotesJSON = new Gson().toJson(currency.getQuotes());

        Supplier<String, Long> supplier = accountTransactionRepository::findAccountTransactionIdByNumber;

        try {
            accountTransactionRepository.madeAccountTransaction(
                    supplier.getAccountId(toAccountNumber), fromAccountId,
                    amount, quotesJSON);
        } catch (JpaSystemException jse) {
            throw new TransactionDeniedException("Transaction denied");
        }
    }
}

@FunctionalInterface
interface Supplier<T, E> {
    E getAccountId(T number);
}