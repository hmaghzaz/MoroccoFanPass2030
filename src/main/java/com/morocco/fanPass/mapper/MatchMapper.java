package com.morocco.fanPass.mapper;

import com.morocco.fanPass.dto.MatchDTO;
import com.morocco.fanPass.entity.Match;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    MatchMapper INSTANCE = Mappers.getMapper(MatchMapper.class);

    MatchDTO toDTO(Match stadium);
    Match toEntity(MatchDTO dto);
}
