package com.poit.hibiscus.service;

import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.CurrencyType;
import java.math.BigDecimal;
import java.util.List;

public interface CardService {
    Card createCard(Card card, Long accountId, Long userId);

    List<Card> getUserAttachedCards(Long id);

    CurrencyType sendMoney(String src, String dest, BigDecimal amount);

    Card findByNum(String num);
}
