package com.poit.hibiscus.dto.converter;

import com.poit.hibiscus.dto.UserDto;
import com.poit.hibiscus.entity.User;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserDtoToUserConverter implements Converter<UserDto, User> {

    private final ModelMapper modelMapper;

    @Override
    public User convert(UserDto source) {
        return modelMapper.map(source, User.class);
    }

}
