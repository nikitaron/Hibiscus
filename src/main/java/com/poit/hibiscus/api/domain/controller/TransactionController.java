package com.poit.hibiscus.api.domain.controller;

import com.poit.hibiscus.dto.TransactionsDto;
import com.poit.hibiscus.entity.Transactions;
import com.poit.hibiscus.service.TransactionsService;
import com.poit.hibiscus.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/transaction/")
public class TransactionController {
    private final UserService userService;
    private final TransactionsService.AccountTransactionService transactionService;
    private final TransactionsService.CardTransactionService cardTransactionService;
    private final ConversionService conversionService;

    @PostMapping("card")
    public ResponseEntity<Void> cardTransaction(@RequestBody TransactionsDto.CardTransactionDto cardTransactionDto) {
        return ResponseEntity.noContent().build();
    }

     @PostMapping("account")
     public ResponseEntity<Void> accountTransaction(@AuthenticationPrincipal Principal principal,
                                                    @RequestBody TransactionsDto.AccountTransactionDto accountTransactionDto) {
        var userId = userService.findUserByEmail(principal.getName()).getId();

        transactionService.insert(conversionService.convert(accountTransactionDto, Transactions.AccountTransaction.class));
        return ResponseEntity.noContent().build();
     }
}

