package com.poit.hibiscus.service.impl;

import com.poit.hibiscus.entity.Passport;
import com.poit.hibiscus.entity.SNS;
import com.poit.hibiscus.entity.User;
import com.poit.hibiscus.service.PassportService;
import com.poit.hibiscus.service.RegistrationService;
import com.poit.hibiscus.service.SnsService;
import com.poit.hibiscus.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final SnsService snsService;
    private final PassportService passportService;

    @Override
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
    }

    @Override
    public void savePassport(Passport passport) {
        snsService.saveSns(passport.getSns());
        passportService.savePassport(passport);
    }
}
