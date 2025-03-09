package com.morocco.fanPass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StadiumDTO {

    private String name;
    private String city;
    private String country;
    private Integer capacity;
    private String imageUrl;

}
