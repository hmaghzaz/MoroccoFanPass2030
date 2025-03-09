package com.morocco.fanPass.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TeamDTO {

    private String name;
    private String country;
    private String flagImageUrl;

}
