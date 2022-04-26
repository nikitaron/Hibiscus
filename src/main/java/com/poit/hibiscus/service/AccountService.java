package com.poit.hibiscus.service;

import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.CardAccount;

public interface AccountService {
    CardAccount createAccount(CardAccount cardAccount, Long userId);
    void deleteAccount(Long id);

    CardAccount findByIban(String iban);
}
