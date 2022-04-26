package com.poit.hibiscus.controller;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.dto.CardDto;
import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.service.AccountService;
import com.poit.hibiscus.service.CardService;
import com.poit.hibiscus.service.UserService;
import lombok.*;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/cards/")
public class CardController {

    private final CardService cardService;
    private final ConversionService conversionService;
    private final UserService userService;
    private final AccountService accountService;

    @PostMapping("new")
    public ResponseEntity<CardDto> createCard(
            @RequestBody AccountCardWrapper accountCardWrapper,
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        var card = conversionService.convert(accountCardWrapper.getCardDto(), Card.class);
        var accountId = accountService.findByIban(accountCardWrapper.getAccountDto().getIban()).getId();
        var userId =  userService.findUserByEmail(userDetails.getUsername()).getId();

        return new ResponseEntity<>(
                conversionService.convert(cardService.createCard(card, accountId, userId), CardDto.class),
                HttpStatus.CREATED
        );
    }
}

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
class AccountCardWrapper {
    private AccountDto accountDto;
    private CardDto cardDto;
}
