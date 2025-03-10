package com.morocco.fanPass.mapper;

import com.morocco.fanPass.dto.OrderDTO;
import com.morocco.fanPass.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toDTO(Order order);
    Order toEntity(OrderDTO dto);

}

