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

public class MatchDTO {

    enum MatchStatus {Scheduled, Ongoing, Completed, Cancelled};
    enum MatchStage {Group_Stage, Round_Of_16, Quarter_Final, Semi_Final, Third_Place, Final};

    private LocalDateTime matchDate;
    private double totaleAmount;
    private MatchStatus matchStatus;
    private MatchStage matchStage;
    private Integer homeTeam;
    private Integer awayTeam;
    private Integer idStatium;
}
