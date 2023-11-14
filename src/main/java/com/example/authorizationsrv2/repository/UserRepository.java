package com.example.authorizationsrv2.repository;

import com.example.authorizationsrv2.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Override
    Optional<User> findById(Long aLong);

    @Override
    List<User> findAll();

     User save(User user);
}
