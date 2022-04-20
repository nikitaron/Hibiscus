package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.repository.CardRepository;
import com.poit.hibiscus.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public void createCard(Card card, AccountDto accountDto) {
        int cvv = (int) (Math.random() * 100);
        long num = (long) (1000_0000_0000_0000L + Math.random() * (Long.MAX_VALUE / 1000L));
        int pin = (int) (Math.random() * 1000);
        card.setCvv(String.valueOf(cvv));
        card.setNumber(String.valueOf(num));
        card.setPin(String.valueOf(pin)); //просто поменять на целочисленные, наверное
    }
}
