package com.API.ProjectAPI.service;


import lombok.NonNull;
import com.API.ProjectAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceApplication {
    private final List<User> users = new ArrayList<>();
    private int idUser=0;

    public User createUsuario(@NonNull User user){
        user.setID(idUser++);
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return this.users;
    }

    public Optional<User> getUserByID(int id){
        return users.stream().filter(idSearch -> idSearch.getID() == id ).findFirst();
    }

    public void removeUserByID(int id){
        getUserByID(id).ifPresent(user -> users.remove(user));
    }

    public Optional<User> updateUserById(int id, User userNew){
        return getUserByID(id).map(user -> {
            user.setName(userNew.getName());
            return user;
        });
        
    }
}
