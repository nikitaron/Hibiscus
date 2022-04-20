package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.repository.CreditRepository;
import com.poit.hibiscus.service.CreditService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditServiceImpl implements CreditService {

    private final CreditRepository creditRepository;
}
