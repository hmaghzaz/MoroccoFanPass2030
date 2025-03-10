package com.morocco.fanPass.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderDTO {

    enum OrderStatus {Pending, Paid, Cancelled, Refunded};

    private LocalDateTime orderDate ;
    private double totalAmount ;
    private OrderStatus orderStatus ;
}
