package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.entity.Passport;
import com.poit.hibiscus.repository.PassportRepository;
import com.poit.hibiscus.service.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {
    private final PassportRepository passportRepository;

    @Override
    public void savePassport(Passport passport) {
        passportRepository.save(passport);
    }
}
