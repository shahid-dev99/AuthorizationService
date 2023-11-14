package com.example.authorizationsrv2.services;

import com.example.authorizationsrv2.models.User;
import com.example.authorizationsrv2.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class UserService implements UserServiceBase{
    private UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository =  userRepository;
    }
    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public String validateUser(Long userId, String pswd) {
        //get the user from the DB
        Optional<User> userOpt = userRepository.findById(userId);
        if(userOpt.get().getPaswrd().equals(pswd)){
            if(userOpt.get().getSessions().size()==0){
                return "No sessions Exists";
            }
            return userOpt.get().getSessions().get(0).getToken();
        }else{
            return "No token found";
        }
    }

    @Override
    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }
}
