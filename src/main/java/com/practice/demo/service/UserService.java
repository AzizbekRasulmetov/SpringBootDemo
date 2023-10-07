package com.practice.demo.service;

import com.practice.demo.entity.UserEntity;
import com.practice.demo.exceptions.UserAlreadyExistsException;
import com.practice.demo.exceptions.UserNotFoundException;
import com.practice.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(@RequestBody UserEntity user) throws UserAlreadyExistsException {
        if (userRepository.findByName(user.getName()) != null) {
            throw new UserAlreadyExistsException("User already exists");
        }
        return userRepository.save(user);
    }

    public UserEntity getUserById(@RequestBody long id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    public List<UserEntity> getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }


}
