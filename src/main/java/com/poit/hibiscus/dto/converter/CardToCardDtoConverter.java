package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.CardDto;
import com.poit.hibiscus.entity.Card;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CardToCardDtoConverter implements Converter<Card, CardDto> {

    private final ModelMapper modelMapper;

    @Override
    public CardDto convert(Card source) {
        return modelMapper.map(source, CardDto.class);
    }
}
