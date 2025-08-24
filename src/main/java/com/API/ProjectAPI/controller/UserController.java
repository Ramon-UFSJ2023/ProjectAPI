package com.API.ProjectAPI.controller;


import com.API.ProjectAPI.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.API.ProjectAPI.service.ServiceApplication;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final ServiceApplication userServices;

    public UserController(ServiceApplication userServices){
        this.userServices = userServices;
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> searchAllUsers = userServices.getAllUsers();
        return ResponseEntity.ok(searchAllUsers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id){
        Optional<User> searchUserByID = userServices.getUserByID(id);
        return  searchUserByID.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        User createdUser = userServices.createUsuario(newUser);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
        Optional<User> userAtualizado = userServices.updateUserById(id, user);
        return userAtualizado.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable int id){
        userServices.removeUserByID(id);
        return ResponseEntity.noContent().build();
    }


}
