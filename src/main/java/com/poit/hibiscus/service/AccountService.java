package com.poit.hibiscus.service;

import com.poit.hibiscus.entity.CardAccount;

public interface AccountService {
    CardAccount createAccount(CardAccount cardAccount);
    void deleteAccount(Long id);
}
