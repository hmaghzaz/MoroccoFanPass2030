package com.morocco.fanPass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketCategoryDTO {

    private double price;
    private Integer totalSeats;
    private Integer availableSeats;
    private Integer idMatch;
    private Integer idSeats;

}
