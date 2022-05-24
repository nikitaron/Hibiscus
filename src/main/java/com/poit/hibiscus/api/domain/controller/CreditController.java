package com.poit.hibiscus.api.domain.controller;

import com.poit.hibiscus.dto.CreditDto;
import com.poit.hibiscus.entity.Credit;
import com.poit.hibiscus.service.CreditService;
import com.poit.hibiscus.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/credits/")
public class CreditController {

    private final CreditService creditService;
    private final UserService userService;
    private final ConversionService conversionService;

    @PostMapping("new")
    public ResponseEntity<CreditDto> createNewCredit(@RequestBody CreditDto creditDto,
        @AuthenticationPrincipal UserDetails userDetails) {

        var creditInfo = conversionService.convert(creditDto, Credit.class);

        var currentUser = userService.findUserByEmail(userDetails.getUsername());

        var newCredit = creditService.saveNew(creditInfo, currentUser);

        return new ResponseEntity<>(
            conversionService.convert(newCredit, CreditDto.class),
            HttpStatus.OK
        );
    }

    //TODO scheduler with notifications
}
