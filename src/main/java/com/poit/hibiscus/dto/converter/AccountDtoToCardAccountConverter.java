package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.dto.UserDto;
import com.poit.hibiscus.entity.CardAccount;
import com.poit.hibiscus.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountDtoToCardAccountConverter implements Converter<AccountDto, CardAccount> {

    private final ModelMapper modelMapper;

    @Override
    public CardAccount convert(AccountDto source) {
        return modelMapper.map(source, CardAccount.class);
    }
}
