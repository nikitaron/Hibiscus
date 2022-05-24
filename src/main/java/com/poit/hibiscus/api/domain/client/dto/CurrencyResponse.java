package com.poit.hibiscus.api.domain.client.dto;

import com.poit.hibiscus.api.domain.client.model.CurrencyType;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.EnumMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyResponse {
    private Map<CurrencyType, BigDecimal> quotes = new EnumMap<>(CurrencyType.class);

    private Instant updatedAt = Instant.now();
}
