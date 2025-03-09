package com.morocco.fanPass.mapper;

import com.morocco.fanPass.dto.TeamDTO;
import com.morocco.fanPass.entity.Team;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeamMapper {

    TeamMapper INSTANCE= Mappers.getMapper(TeamMapper.class);

    TeamDTO toDTO(Team team);
    Team toEntity(TeamDTO dto);

}
