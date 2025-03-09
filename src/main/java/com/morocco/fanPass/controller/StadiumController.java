package com.morocco.fanPass.controller;

import com.morocco.fanPass.dto.StadiumDTO;
import com.morocco.fanPass.entity.Stadium;
import com.morocco.fanPass.service.StadiumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stadium")
public class StadiumController {

    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService){
        this.stadiumService = stadiumService;
    }

    @GetMapping("/all")
    public List<StadiumDTO> getAllStadiums(){
        return stadiumService.getAllStadiums();
    }

    @GetMapping("/{id}")
    public StadiumDTO getStadiumById(@PathVariable Long id){
        return stadiumService.getStadiumById(id);
    }

    @PostMapping("/create")
    public StadiumDTO createStadium(@RequestBody Stadium stadium){
        return stadiumService.creatStadium(stadium);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteStadiumById(@PathVariable Long id){
        return stadiumService.deleteStadiumById(id);
    }
}
