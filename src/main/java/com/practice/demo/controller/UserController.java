package com.practice.demo.controller;

import com.practice.demo.entity.UserEntity;
import com.practice.demo.exceptions.UserAlreadyExistsException;
import com.practice.demo.exceptions.UserNotFoundException;
import com.practice.demo.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/all")
    public List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{id}")
    public ResponseEntity getUserById(@NonNull @PathVariable long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (UserNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong");
        }
    }

  /*@GetMapping("{id}")
    public UserDTO getUserById(@PathVariable @NonNull String id) {
        return users.stream()
                .filter(user -> id.equals(user.id()))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }*/

    @PostMapping("/create")
    public ResponseEntity createUser(@NonNull @RequestBody UserEntity user) {
        try {
            userService.registerUser(user);
            return ResponseEntity.ok("User registered successfully");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Something went wrong :-(");
        }
    }

   /* @PutMapping("/update")
    public UserDTO updateUser(@RequestBody @NonNull UserDTO user) {
        UserDTO userToUpdate = users.stream()
                .filter(user1 -> user1.id().equals(user.id()))
                .findFirst()
                .orElseThrow(NotFoundException::new);
        int index = users.indexOf(userToUpdate);
        users.set(index, user);
        return user;
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable @NonNull String id) {
        UserDTO userToDelete = users.stream().filter(user -> user.id().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
        users.remove(userToDelete);
    }*/

}
