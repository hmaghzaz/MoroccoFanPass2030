package com.morocco.fanPass.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
@Entity
@Table
public class Match { 

    enum MatchStatus {Scheduled, Ongoing, Completed, Cancelled};
    enum MatchStage {Group_Stage, Round_Of_16, Quarter_Final, Semi_Final, Third_Place, Final};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMatch;
    private LocalDateTime matchDate;
    private double totaleAmount;
    private MatchStatus matchStatus;
    private MatchStage matchStage;
    
    @ManyToOne
    @JoinColumn(name = "home_team_id", nullable = false)
    private Team homeTeam;
    
    @ManyToOne
    @JoinColumn(name = "away_team_id", nullable = false)
    private Team awayTeam;

    @ManyToOne
    @JoinColumn(name = "stadium_id", nullable = false)
    private Stadium stadium;

    @OneToMany(mappedBy = "match", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TicketCategory> ticketCategories;


}
