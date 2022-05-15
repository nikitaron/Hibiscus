package com.poit.hibiscus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountCardWrapper {
    @JsonProperty("accountDto")
    private AccountDto accountDto;

    @JsonProperty("cardDto")
    private CardDto cardDto;
}
