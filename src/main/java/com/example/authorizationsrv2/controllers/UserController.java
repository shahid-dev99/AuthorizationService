package com.example.authorizationsrv2.controllers;

import com.example.authorizationsrv2.dtos.UserDto;
import com.example.authorizationsrv2.models.User;
import com.example.authorizationsrv2.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private UserService userService;
    UserController(UserService userService){
        this.userService =  userService;
    }
    public User dtoToUser(UserDto dto){
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPaswrd(dto.getPaswrd());
        user.setUsrname(dto.getUsrname());
        user.setFullName(dto.getFullName());
        return  user;
    }
    public UserDto userToDto(User user){
        UserDto dto = new UserDto();
        dto.setEmail(user.getEmail());
        dto.setId(user.getId());
        dto.setUsrname(user.getUsrname());
        dto.setFullName(user.getFullName());
        dto.setPaswrd(user.getPaswrd());
        return  dto;
    }
    //create user
    @PostMapping("user")
   public UserDto createUser(@RequestBody UserDto dto){
        User user = dtoToUser(dto);
        User savedUser =  userService.createUser(user);
        UserDto  userDto = userToDto(savedUser);
        return  userDto;
    }

    @GetMapping("/users")
    public List<UserDto> getUsers(){
       List<User> users =  userService.getUsers();
       List<UserDto> userDtos =  new ArrayList<>();
       for(User user:users){
           userDtos.add(userToDto(user));
       }
       return userDtos;
     }
     @GetMapping("user/{id}")
    public UserDto getUser(@PathVariable("id") Long userId){
            Optional<User> user = userService.getUser(userId);
            return userToDto(user.get());
     }
     @GetMapping("validateUser/{userId}/{pswd}")
     public String validatedUser(@PathVariable("userId") Long usId,
                                 @PathVariable("pswd") String paswd){
        return userService.validateUser(usId,paswd);
     }
}
