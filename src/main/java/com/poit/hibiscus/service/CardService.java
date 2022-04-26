package com.poit.hibiscus.service;

import com.poit.hibiscus.entity.Card;

public interface CardService {
    Card createCard(Card card, Long accountId, Long userId);
}
