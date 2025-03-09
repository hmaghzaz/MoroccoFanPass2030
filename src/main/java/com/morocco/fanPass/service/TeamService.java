package com.morocco.fanPass.service;

import com.morocco.fanPass.dto.TeamDTO;
import com.morocco.fanPass.entity.Team;
import com.morocco.fanPass.mapper.TeamMapper;
import com.morocco.fanPass.repository.TeamRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamService {

     private final TeamMapper teamMapper;
     private final TeamRepository teamRepository;

     public TeamService(TeamMapper teamMapper, TeamRepository teamRepository) {

         this.teamMapper = teamMapper;
         this.teamRepository = teamRepository;
     }

     public List<TeamDTO> getAllTeams() {
         return teamRepository.findAll().stream().map(teamMapper::toDTO).collect(Collectors.toList());
     }

     public TeamDTO createTeam(Team team){
         Team teamEntity = teamRepository.save(team);
         return teamMapper.toDTO(teamEntity);
     }

     public TeamDTO getTeamById(Long id){
         return teamRepository.findById(id).map(teamMapper::toDTO).orElseThrow(()-> new RuntimeException("Team with given id : " + id + " not exist"));
     }

     public ResponseEntity<String> deleteTeamById(Long id){
         if(!teamRepository.existsById(id)){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Team with given id : " + id + " not exist");
         }
         teamRepository.deleteById(id);
         return ResponseEntity.ok("Team with given id: " + id + " is successfully deleted");
     }

}
