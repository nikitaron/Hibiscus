package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.AccountDto;
import com.poit.hibiscus.entity.CardAccount;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;

@Component
@AllArgsConstructor
public class AccountToAccountDtoConverter implements Converter<CardAccount, AccountDto> {

    private final ModelMapper modelMapper;

    @Override
    public AccountDto convert(CardAccount source) {
        return modelMapper.map(source, AccountDto.class);
    }
}
