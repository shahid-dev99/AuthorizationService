package com.example.authorizationsrv2.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;
    private String email;
    private String paswrd;
    private String usrname;
    private String fullName;
}
