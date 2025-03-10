package com.morocco.fanPass.mapper;

import com.morocco.fanPass.dto.TicketDTO;
import com.morocco.fanPass.entity.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    TicketDTO toDTO(Ticket stadium);
    Ticket toEntity(TicketDTO dto);
}
