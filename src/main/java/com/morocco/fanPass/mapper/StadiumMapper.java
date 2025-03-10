package com.morocco.fanPass.mapper;

import com.morocco.fanPass.dto.StadiumDTO;
import com.morocco.fanPass.entity.Stadium;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface StadiumMapper {

    StadiumMapper INSTANCE = Mappers.getMapper(StadiumMapper.class);

    StadiumDTO toDTO(Stadium stadium);
    Stadium toEntity(StadiumDTO dto);
}
 