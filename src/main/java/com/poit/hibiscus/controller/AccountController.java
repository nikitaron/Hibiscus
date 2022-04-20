package com.poit.hibiscus.controller;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.entity.CardAccount;
import com.poit.hibiscus.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts/")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final ConversionService conversionService;

    @PostMapping("new")
    public ResponseEntity<CardAccount> createAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(
                accountService.createAccount(conversionService.convert(accountDto, CardAccount.class)), HttpStatus.CREATED
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
