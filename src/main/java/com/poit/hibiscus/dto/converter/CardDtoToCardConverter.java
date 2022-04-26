package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.CardDto;
import com.poit.hibiscus.dto.UserDto;
import com.poit.hibiscus.entity.Card;
import com.poit.hibiscus.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CardDtoToCardConverter  implements Converter<CardDto, Card> {

    private final ModelMapper modelMapper;

    @Override
    public Card convert(CardDto source) {
        return modelMapper.map(source, Card.class);
    }
}
