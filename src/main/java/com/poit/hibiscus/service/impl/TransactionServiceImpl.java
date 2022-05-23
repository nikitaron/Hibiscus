package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.repository.TransactionRepository;
import com.poit.hibiscus.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

}
