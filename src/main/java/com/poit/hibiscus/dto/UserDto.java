package com.poit.hibiscus.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.poit.hibiscus.entity.Passport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Passport passport;

    private String email;
    private String password;
}
