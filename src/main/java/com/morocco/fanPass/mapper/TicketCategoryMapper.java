package com.morocco.fanPass.mapper;


import com.morocco.fanPass.dto.TicketCategoryDTO;
import com.morocco.fanPass.entity.TicketCategory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketCategoryMapper {

    TicketCategoryMapper INSTANCE = Mappers.getMapper(TicketCategoryMapper.class);

    TicketCategoryDTO toDTO(TicketCategory stadium);
    TicketCategory toEntity(TicketCategoryDTO dto);
}
