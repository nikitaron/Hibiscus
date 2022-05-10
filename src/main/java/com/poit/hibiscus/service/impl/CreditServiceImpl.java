package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.entity.Credit;
import com.poit.hibiscus.entity.User;
import com.poit.hibiscus.repository.CreditRepository;
import com.poit.hibiscus.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;

    @Override
    public Credit saveNew(Credit credit, User user) {
        credit.setPassport(user.getPassport());
        return creditRepository.save(credit);
    }
}
