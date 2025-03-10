package com.morocco.fanPass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class SeatCategoryDTO {

    private String seatName;
    private String description;
    private Integer idStadium;
}
 