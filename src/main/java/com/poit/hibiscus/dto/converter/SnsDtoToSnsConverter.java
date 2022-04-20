package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.SnsDto;
import com.poit.hibiscus.entity.SNS;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class SnsDtoToSnsConverter implements Converter<SnsDto, SNS> {

    private final ModelMapper modelMapper;

    @Override
    public SNS convert(SnsDto source) {
        return modelMapper.map(source, SNS.class);
    }
}
