package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.UserDto;
import com.poit.hibiscus.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserToUserDroConverter implements Converter<User, UserDto> {

    private final ModelMapper modelMapper;

    @Override
    public UserDto convert(User source) {
        return modelMapper.map(source, UserDto.class);
    }
}
