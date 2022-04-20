package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.PassportDto;
import com.poit.hibiscus.entity.Passport;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class PassportDtoToPassportConverter implements Converter<PassportDto, Passport> {

    private final ModelMapper modelMapper;

    @Override
    public Passport convert(PassportDto passportDto) {
        return modelMapper.map(passportDto, Passport.class);
    }
}
