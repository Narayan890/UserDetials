package com.example.user.UserDetails.service;

import com.example.user.UserDetails.model.User;
import com.example.user.UserDetails.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(String name){
        return userRepository.getAllUser(name);
    }
    public void registerUser(User newUser) {
        userRepository.registerUser(newUser);
    }
}
