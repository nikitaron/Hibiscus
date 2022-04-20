package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.entity.CardAccount;
import com.poit.hibiscus.entity.CurrencyType;
import com.poit.hibiscus.repository.AccountRepository;
import com.poit.hibiscus.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public CardAccount createAccount(CardAccount cardAccount) {

        long accountNum = (long) (1000_0000_0000_0000L + Math.random() * (Long.MAX_VALUE / 1000L));
        int randomBalanceNum = (int) (1000 + Math.random() * 9999);

        String iban = "BY" + "24" + "1234" + randomBalanceNum + accountNum;

        var newCardAccount = CardAccount.builder()
                .currencyType(cardAccount.getCurrencyType())
                .money(BigDecimal.ZERO)
                .number(String.valueOf(accountNum))
                .iban(iban)
                .build();

        return accountRepository.save(newCardAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}