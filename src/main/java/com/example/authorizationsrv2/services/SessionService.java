package com.example.authorizationsrv2.services;

import com.example.authorizationsrv2.models.Session;
import com.example.authorizationsrv2.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
@Service
public class SessionService implements SessionSrvBase{
    private SessionRepository sessionRepository;
    SessionService(SessionRepository sessionRepository){
        this.sessionRepository = sessionRepository;
    }
    @Override
    public Session createSession(Session session) {
        // create a random token and save
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        session.setToken(saltStr);
        return sessionRepository.save(session);
    }

    @Override
    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }
}
