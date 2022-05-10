package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.CreditDto;
import com.poit.hibiscus.entity.Credit;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreditToCreditDtoConverter implements Converter<Credit, CreditDto> {

    private final ModelMapper modelMapper;

    @Override
    public CreditDto convert(Credit source) {
        return modelMapper.map(source, CreditDto.class);
    }
}
