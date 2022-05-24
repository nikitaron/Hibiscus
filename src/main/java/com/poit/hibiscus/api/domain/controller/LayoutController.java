package com.poit.hibiscus.api.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LayoutController {

    @GetMapping("signup")
    public String getSignUpPage() {
        return "signUp";
    }

    @GetMapping("signin")
    public String getSignInPage() {
        return "signIn";
    }

    @GetMapping("passport-attachment")
    public String getPassportPage() {
        return "passportPage";
    }

    @GetMapping("main-page")
    public String getMainPage() {
        return "mainPage";
    }
}
