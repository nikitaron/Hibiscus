package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.entity.CardAccount;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountDtoToCardAccountConverter {

    private final ModelMapper modelMapper;

    public CardAccount convert(AccountDto accountDto) {
        return modelMapper.map(accountDto, CardAccount.class);
    }
}
