package com.poit.hibiscus.api.domain.client;

import com.poit.hibiscus.api.domain.client.model.Currency;
import reactor.core.publisher.Mono;

public interface CurrencyClient {

    Mono<Currency> getCurrency();
}
