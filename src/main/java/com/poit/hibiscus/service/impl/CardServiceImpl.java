package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.CurrencyType;
import com.poit.hibiscus.repository.AccountRepository;
import com.poit.hibiscus.repository.CardRepository;
import com.poit.hibiscus.service.CardService;
import java.math.BigDecimal;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    @Override
    public Card createCard(Card card, Long accountId, Long userId) {
        int cvv = (int) (Math.random() * 899 + 100);
        long num = (long) (1000_0000_0000_0000L + Math.random() * (Long.MAX_VALUE / 1000L));
        int pin = (int) (Math.random() * 1000);
        var newCard = Card.builder()
            .accountId(accountId)
            .userId(userId)
            .cvv(String.valueOf(cvv))
            .pin(String.valueOf(pin))
            .number(String.valueOf(num))
            .expirationTime(card.getExpirationTime())
            .build();

        return cardRepository.save(newCard);
    }

    @Override
    public List<Card> getUserAttachedCards(Long id) {
        return cardRepository.getAllByUserId(id);
    }

    @Override
    public CurrencyType sendMoney(String src, String dest, BigDecimal amount) {
        var srcCard = cardRepository.getCardByNumber(src);
        var destCard = cardRepository.getCardByNumber(dest);
        var destAccount = accountRepository.getById(destCard.getId());
        var srcAccount = accountRepository.getById(srcCard.getId());
        destAccount.addMoney(amount);
        srcAccount.subMoney(amount);
        accountRepository.save(destAccount);
        accountRepository.save(srcAccount);

        return destAccount.getCurrencyType();
    }

    @Override
    public Card findByNum(String num) {
        return cardRepository.getCardByNumber(num);
    }
}
