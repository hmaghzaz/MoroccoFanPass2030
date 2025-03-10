package com.morocco.fanPass.service;

import com.morocco.fanPass.dto.StadiumDTO;
import com.morocco.fanPass.entity.Stadium;
import com.morocco.fanPass.mapper.StadiumMapper;
import com.morocco.fanPass.repository.StadiumRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List; 
import java.util.stream.Collectors;

@Service
public class StadiumService {

     private final StadiumMapper stadiumMapper;
     private final StadiumRepository stadiumRepository;

     public StadiumService(StadiumMapper stadiumMapper, StadiumRepository stadiumRepository){
         this.stadiumMapper = stadiumMapper;
         this.stadiumRepository = stadiumRepository;
     }

     public List<StadiumDTO> getAllStadiums(){
         return stadiumRepository.findAll().stream().map(stadiumMapper::toDTO).collect(Collectors.toList());
     }

     public StadiumDTO creatStadium(Stadium stadium){
         Stadium stadiumEntity = stadiumRepository.save(stadium);
         return stadiumMapper.toDTO(stadiumEntity);
     }

     public StadiumDTO getStadiumById(Long id){
         return stadiumRepository.findById(id).map(stadiumMapper::toDTO).orElseThrow(()-> new RuntimeException("Stadium with given id : " + id + " not exist"));
     }

     public ResponseEntity<String> deleteStadiumById(Long id){
         if(!stadiumRepository.existsById(id)){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stadium with given id : " + id + " not exist");
         }
         stadiumRepository.deleteById(id);
         return ResponseEntity.ok("Stadium with given id: " + id + " is successfully deleted");

     }

}
