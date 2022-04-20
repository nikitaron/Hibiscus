package com.poit.hibiscus.controller;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.dto.CardDto;
import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.service.AccountService;
import com.poit.hibiscus.service.CardService;
import com.poit.hibiscus.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cards")
public class CardController {

    private final CardService cardService;
    private final ConversionService conversionService;
    private final UserService userService;
    private final AccountService accountService;

    @PostMapping("new")
    public ResponseEntity<Void> createCard(@RequestBody CardDto cardDto, @RequestBody AccountDto accountDto) {
        cardService.createCard(conversionService.convert(cardDto, Card.class), accountDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
