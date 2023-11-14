package com.example.authorizationsrv2.controllers;

import com.example.authorizationsrv2.dtos.SessionDto;
import com.example.authorizationsrv2.models.Session;
import com.example.authorizationsrv2.services.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {
    private SessionService sessionService;

    SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }
    public Session dtoToSession(SessionDto dto){
        Session session =  new Session();
        session.setToken(dto.getToken());
        session.setUsrId(dto.getUsrId());
        return session;
    }
    public SessionDto seesionToDto(Session session){
        SessionDto dto = new SessionDto();
        dto.setToken(session.getToken());
        dto.setId(session.getId());
        dto.setUsrId(session.getUsrId());
        return dto;
    }
    @PostMapping
    public SessionDto createSession(@RequestBody SessionDto dto){

        Session session = sessionService.createSession(dtoToSession(dto));
        return seesionToDto(session);
    }
    @GetMapping
    public List<SessionDto> getAllSessions(){

        List<Session> sessions = sessionService.getAllSessions();
        List<SessionDto> dto = new ArrayList<>();

        for(Session session : sessions){
            dto.add(seesionToDto(session));
        }
        return dto;
    }
}
