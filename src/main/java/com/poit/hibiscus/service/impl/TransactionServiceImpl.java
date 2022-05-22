package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.Transaction;
import com.poit.hibiscus.entity.User;
import com.poit.hibiscus.repository.TransactionRepository;
import com.poit.hibiscus.service.TransactionService;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction save(Transaction transaction) {
        transaction.setTransactionTime(LocalDateTime.now());
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllAttachedToUser(User user) {
        var cards = user.getCards();
        var transactions = new LinkedList<Transaction>();
        cards.forEach(c -> transactions.addAll(transactionRepository.findAllByCard(c)));

        return transactions.stream()
            .sorted(Comparator.comparing(Transaction::getTransactionTime))
            .collect(Collectors.toList());
    }

}
