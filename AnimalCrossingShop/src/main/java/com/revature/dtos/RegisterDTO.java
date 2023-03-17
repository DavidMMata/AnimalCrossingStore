package com.revature.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterDTO {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String email;


}