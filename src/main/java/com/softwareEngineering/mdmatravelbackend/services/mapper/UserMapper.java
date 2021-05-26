package com.softwareEngineering.mdmatravelbackend.services.mapper;

import com.softwareEngineering.mdmatravelbackend.data.models.RegisterUserDto;
import com.softwareEngineering.mdmatravelbackend.data.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    default User toEntity(RegisterUserDto userRegisterDto) {
        User user = new User();
        user.setFirstName(userRegisterDto.getFirstName());
        user.setLastName(userRegisterDto.getLastName());
        user.setEmail(userRegisterDto.getEmail());
        user.setIsAdmin(userRegisterDto.getIsAdmin());

        return user;
    }
}
