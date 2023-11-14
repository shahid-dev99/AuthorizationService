package com.example.authorizationsrv2.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Session extends BaseModel{
    private String token;
    @JsonBackReference
    @ManyToOne
    private User usrId;
}
