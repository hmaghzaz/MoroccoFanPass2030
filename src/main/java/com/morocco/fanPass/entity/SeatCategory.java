package com.morocco.fanPass.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
@Entity
@Table
public class SeatCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeat;
    private String seatName;
    private String description;

    @ManyToOne
    @JoinColumn(name = "stadium_id", nullable = false)
    private Stadium stadium;

    @OneToMany(mappedBy = "seatCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TicketCategory> ticketCategories;

}


