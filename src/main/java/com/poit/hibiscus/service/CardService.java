package com.poit.hibiscus.service;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.entity.Card;

public interface CardService {
    void createCard(Card card, AccountDto accountDto);
}
