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
public class TicketDTO {

    private String TicketNumber ;
    private Integer seatNumber ;
    private Boolean isUsed;
    private LocalDateTime TIMESTAMP;
    private Integer idOrder;
    private Integer idCategorie ;
}
 