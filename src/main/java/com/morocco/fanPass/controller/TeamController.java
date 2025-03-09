package com.morocco.fanPass.controller;


import com.morocco.fanPass.dto.TeamDTO;
import com.morocco.fanPass.entity.Team;
import com.morocco.fanPass.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService = teamService;
    }

    @GetMapping("/all")
    public List<TeamDTO> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public TeamDTO getTeamById(@PathVariable Long id){
        return teamService.getTeamById(id);
    }

    @PostMapping("/create")
    public TeamDTO createTeam(@RequestBody Team team){
        return teamService.createTeam(team);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteTeamById(@PathVariable Long id){
        return teamService.deleteTeamById(id);
    }

}
