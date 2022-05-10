package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.CreditDto;
import com.poit.hibiscus.entity.Credit;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CreditDtoToCreditConverter implements Converter<CreditDto, Credit> {

    private final ModelMapper modelMapper;

    @Override
    public Credit convert(CreditDto source) {
        return modelMapper.map(source, Credit.class);
    }
}
