package com.poit.hibiscus.controller;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.entity.CardAccount;
import com.poit.hibiscus.service.AccountService;
import com.poit.hibiscus.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/accounts/")
@AllArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final ConversionService conversionService;
    private final UserService userService;

    @PostMapping("new")
    public ResponseEntity<CardAccount> createAccount(@RequestBody AccountDto accountDto,
                                                     @AuthenticationPrincipal UserDetails userDetails) {

        return new ResponseEntity<>(
                accountService.createAccount(
                        conversionService.convert(accountDto, CardAccount.class),
                        userService.findUserByEmail(userDetails.getUsername()).getId()
                ),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
