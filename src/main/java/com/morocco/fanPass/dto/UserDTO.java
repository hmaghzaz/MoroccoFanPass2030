package com.morocco.fanPass.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String firsName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String nationality;
}
