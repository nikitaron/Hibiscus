package com.poit.hibiscus.controller;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.entity.CardAccount;
import com.poit.hibiscus.service.AccountService;
import com.poit.hibiscus.service.UserService;
import java.util.List;
import java.util.stream.Collectors;
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
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto,
        @AuthenticationPrincipal UserDetails userDetails) {

        return new ResponseEntity<>(
            conversionService.convert(
                accountService.createAccount(
                    conversionService.convert(accountDto, CardAccount.class),
                    userService.findUserByEmail(userDetails.getUsername()).getId()),
                AccountDto.class),
            HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAccounts() {
        return new ResponseEntity<>(
            accountService.getAll().stream()
                .map(a -> conversionService.convert(a, AccountDto.class))
                .collect(Collectors.toList()),
            HttpStatus.OK);
    }

    @GetMapping("user-attached")
    public ResponseEntity<List<AccountDto>> getAttachedAccounts(
        @AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(accountService.getAccountsByUserId(
                userService.findUserByEmail(userDetails.getUsername()).getId())
                .stream()
                    .map(a -> conversionService.convert(a, AccountDto.class))
                    .collect(Collectors.toList()),
            HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
