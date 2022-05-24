package com.poit.hibiscus.api.domain.controller;

import com.poit.hibiscus.api.domain.client.dto.CurrencyResponse;
import com.poit.hibiscus.api.domain.client.model.Currency;
import com.poit.hibiscus.api.domain.client.operation.CurrencyOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.ExecutionException;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/currency")
public class CurrencyController {
    private final CurrencyOperation currencyOperation;
    private final ConversionService conversionService;

    @GetMapping
    public Mono<CurrencyResponse> getCurrency() throws InterruptedException {
        return Mono.just(conversionService.convert(currencyOperation.activate(), CurrencyResponse.class));
    }
}
