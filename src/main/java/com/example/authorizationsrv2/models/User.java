package com.example.authorizationsrv2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class User extends BaseModel{
    private String email;
    private String paswrd;
    private String usrname;
    private String fullName;
    @OneToMany(mappedBy = "usrId")
    private List<Session> sessions;

}
