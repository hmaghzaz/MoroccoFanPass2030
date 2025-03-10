package com.morocco.fanPass.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
@Entity
@Table
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTicket;
    private String TicketNumber ;
    private Integer seatNumber ;
    private Boolean isUsed;
    private LocalDateTime TIMESTAMP;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable = false)
    private TicketCategory categorie;

    public Long getId(){
        return idTicket;
    }

    public TicketCategory getTicketCategory() {
        return categorie;
    }

    public void setTicketCategory(TicketCategory categorie) {
        this.categorie = categorie;
    }

}
