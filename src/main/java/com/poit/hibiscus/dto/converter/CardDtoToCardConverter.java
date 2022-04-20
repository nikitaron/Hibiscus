package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.CardDto;
import com.poit.hibiscus.entity.Card;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CardDtoToCardConverter {

    private final ModelMapper modelMapper;

    public Card convert(CardDto cardDto) {
        return modelMapper.map(cardDto, Card.class);
    }
}
