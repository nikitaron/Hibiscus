package com.poit.hibiscus.api.domain.client.operation;

import com.poit.hibiscus.api.domain.client.CurrencyClient;
import com.poit.hibiscus.api.domain.client.model.Currency;
import com.poit.hibiscus.api.domain.client.model.CurrencyType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
@RequiredArgsConstructor
public class CurrencyOperation {

    private final CurrencyClient currencyClient;

    public Currency activate() throws InterruptedException {
        final Map<CurrencyType, BigDecimal> quotes = new EnumMap<>(CurrencyType.class);

        CompletableFuture
                .supplyAsync(currencyClient::getCurrency)
                .exceptionallyAsync(e -> {
                    log.warn("Exception occurred in currency method: {}", e.getMessage());

                    return Mono.just(new Currency());
        }).thenApplyAsync(data -> data.subscribe(currency -> currency.getQuotes().entrySet()
                .parallelStream()
                .filter(s -> s.getKey() != null)
                .filter(s -> s.getKey().equals(CurrencyType.USDBYN) ||
                        s.getKey().equals(CurrencyType.USDRUB) ||
                        s.getKey().equals(CurrencyType.USDEUR))
                .findFirst().ifPresent(s -> quotes.put(s.getKey(), s.getValue()))));

        Thread.sleep(1000);

        return Currency.builder()
                .quotes(quotes)
                .build();
    }
}
