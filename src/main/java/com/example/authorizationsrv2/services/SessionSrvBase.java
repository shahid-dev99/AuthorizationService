package com.example.authorizationsrv2.services;

import com.example.authorizationsrv2.models.Session;

import java.util.List;

public interface SessionSrvBase {
   public Session createSession(Session session);
   List<Session> getAllSessions();
}
