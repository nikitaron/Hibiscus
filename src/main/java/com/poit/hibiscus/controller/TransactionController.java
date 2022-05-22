package com.poit.hibiscus.controller;

import com.poit.hibiscus.dto.CardTransactionWrapper;
import com.poit.hibiscus.dto.TransactionDto;
import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.Transaction;
import com.poit.hibiscus.service.CardService;
import com.poit.hibiscus.service.TransactionService;
import com.poit.hibiscus.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transactions/")
@AllArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;
    private final ConversionService conversionService;
    private final UserService userService;
    private final CardService cardService;

    @PostMapping("new")
    public ResponseEntity<TransactionDto> createTransaction(
        @RequestBody CardTransactionWrapper cardTransactionWrapper) {
        var transaction = conversionService.convert(cardTransactionWrapper.getTransactionDto(),
            Transaction.class);

        var currencyType = cardService.sendMoney(cardTransactionWrapper.getCardNumber(), transaction.getToAccount(),
            transaction.getAmount());

        transaction.setCurrencyType(currencyType);

        return new ResponseEntity<>(
            conversionService.convert(
                transactionService.save(transaction),
                TransactionDto.class),
            HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TransactionDto>> getAllTransactions(
        @AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(
                transactionService.getAllAttachedToUser(userService.findUserByEmail(userDetails.getUsername())).stream()
                    .map(t -> conversionService.convert(t, TransactionDto.class)).collect(Collectors.toList()),
                HttpStatus.OK);
    }
}
