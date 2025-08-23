package service;


import model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceApplication {
    private List<User> Users = new ArrayList<>();
    private int IdUser = 1;

    public User createUsuario(User user, String name){
        user.setID(IdUser++);
        user.setName(name);
        Users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return Users;
    }

    public Optional<User> getUserByID(int id){
        return Users.stream().filter(idSearch -> idSearch.getID() == id ).findFirst();
    }

    public void RemoveUserByID(int id){
        getUserByID(id).ifPresent(user -> Users.remove(user));
        Users.removeIf(idSearch -> idSearch.getID() == id);
    }

}
