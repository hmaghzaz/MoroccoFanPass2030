package com.morocco.fanPass.mapper;

import com.morocco.fanPass.dto.UserDTO;
import com.morocco.fanPass.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDTO(User stadium);
    User toEntity(UserDTO dto);
}
