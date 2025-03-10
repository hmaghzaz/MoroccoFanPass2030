package com.morocco.fanPass.mapper;

import com.morocco.fanPass.dto.SeatCategoryDTO;
import com.morocco.fanPass.entity.SeatCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SeatCategoryMapper {

    SeatCategoryMapper INSTANCE = Mappers.getMapper(SeatCategoryMapper.class);

    SeatCategoryDTO toDTO(SeatCategory stadium);
    SeatCategory toEntity(SeatCategoryDTO dto);
}
