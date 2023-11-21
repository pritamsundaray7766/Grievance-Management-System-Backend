package com.example.springbackend.services;

import com.example.springbackend.model.User;
import com.example.springbackend.playloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Long user_Id);
    UserDto  getUserById(Long user_Id);
    List<UserDto> getAllUsers();
    void deleteUser(Long user_Id);


}
