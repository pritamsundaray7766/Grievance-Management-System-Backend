package com.example.springbackend.services.impl;

import com.example.springbackend.model.User;
import com.example.springbackend.exception.ResourceNotFoundException;
import com.example.springbackend.playloads.UserDto;
import com.example.springbackend.repository.UserRepository;
import com.example.springbackend.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user=this.dtoToUser(userDto);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long user_id) {
       User user = this.userRepository.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User","id",user_id));
      user.setFirst_name(userDto.getFirst_name());
      user.setMiddle_name(userDto.getMiddle_name());
      user.setLast_name(userDto.getLast_name());
      user.setContact((int) userDto.getContact());
      user.setEmail(userDto.getEmail());
      user.setPassword(userDto.getPassword());

      User updatedUser = this.userRepository.save(user);
      UserDto userDto1 = this.userToDto(updatedUser);
      return userDto1;
    }

    @Override
    public UserDto getUserById(Long user_id) {
        User user = this.userRepository.findById(user_id).orElseThrow(()->new ResourceNotFoundException("User", "Id", user_id));

        return this.userToDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Long user_id) {
        User user= this.userRepository.findById(user_id).orElseThrow(()-> new ResourceNotFoundException("User", "id", user_id));
        this.userRepository.delete(user);
    }
    public User dtoToUser(UserDto userDto){
        User user = this.modelMapper.map(userDto, User.class);
        return user;
    }
    public UserDto userToDto(User user){
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }
}
