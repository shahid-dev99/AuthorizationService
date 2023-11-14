package com.example.authorizationsrv2.services;

import com.example.authorizationsrv2.models.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceBase {
    public List<User> getUsers();
    public User createUser(User user);
    public String validateUser( Long userId, String pswd);
    public Optional<User> getUser(Long id);
}
