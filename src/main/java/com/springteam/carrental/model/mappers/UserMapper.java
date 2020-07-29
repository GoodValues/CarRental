package com.springteam.carrental.model.mappers;

import com.springteam.carrental.model.dto.CarDTO;
import com.springteam.carrental.model.dto.UserDTO;
import com.springteam.carrental.model.entity.Car;
import com.springteam.carrental.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToDto(User user);
    User dtoToUser(UserDTO userDTO);
}
