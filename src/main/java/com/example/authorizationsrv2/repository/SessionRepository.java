package com.example.authorizationsrv2.repository;

import com.example.authorizationsrv2.models.Session;
import com.example.authorizationsrv2.models.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SessionRepository extends JpaRepository<Session,Long>{
     Session save(Session session);
     List<Session> findAll();
}
