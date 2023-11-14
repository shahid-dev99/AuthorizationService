package com.example.authorizationsrv2.dtos;

import com.example.authorizationsrv2.models.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SessionDto {
    private Long id;
    private String token;
    private User usrId;
}
