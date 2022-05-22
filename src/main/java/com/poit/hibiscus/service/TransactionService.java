package com.poit.hibiscus.service;

import com.poit.hibiscus.entity.Transaction;
import com.poit.hibiscus.entity.User;
import java.util.List;

public interface TransactionService {
    Transaction save(Transaction transaction);

    List<Transaction> getAllAttachedToUser(User user);
}
