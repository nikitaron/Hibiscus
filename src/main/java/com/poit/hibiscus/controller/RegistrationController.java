package com.poit.hibiscus.controller;

import com.poit.hibiscus.dto.PassportDto;
import com.poit.hibiscus.dto.UserDto;
import com.poit.hibiscus.entity.Passport;
import com.poit.hibiscus.entity.User;
import com.poit.hibiscus.service.RegistrationService;
import com.poit.hibiscus.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/account/")
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final ConversionService conversionService;
    private final RegistrationService registrationService;

    @PostMapping("signup")
    public ResponseEntity<String> signUp(@RequestBody UserDto userDto) {
        User user = conversionService.convert(userDto, User.class);
        registrationService.saveUser(user);
        return new ResponseEntity<>("You were successfully signed up", HttpStatus.ACCEPTED);
    }

    @PostMapping("passport/{id}")
    public ResponseEntity<String> passportData(@PathVariable("id") Long id, @RequestBody PassportDto passportDto) {
        var passport = conversionService.convert(passportDto, Passport.class);
        registrationService.savePassport(passport);
        userService.updateUser(id, passport);

        return new ResponseEntity<>("Your passport was successfully accepted", HttpStatus.ACCEPTED);
    }
}
