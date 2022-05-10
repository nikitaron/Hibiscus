package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.PassportDto;
import com.poit.hibiscus.entity.Passport;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PassportToPassportDtoConverter implements Converter<Passport, PassportDto> {

    private final ModelMapper modelMapper;

    @Override
    public PassportDto convert(Passport source) {
        return modelMapper.map(source, PassportDto.class);
    }
}
