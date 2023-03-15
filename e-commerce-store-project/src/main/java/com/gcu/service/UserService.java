package com.gcu.service;

import java.util.ArrayList;
import java.util.List;

import com.gcu.model.LoginModel;


public class UserService {

    private List<LoginModel> users = new ArrayList<>();
    
    public UserService() {
        LoginModel user = new LoginModel();
        user.setEmail("demo@gmail.com");
        user.setUsername("demo444");
        user.setPassword("demo444");
        addUser(user);
        System.out.println("added user");
    }
    
    public void addUser(LoginModel user) {
        users.add(user);
    }
    
    public void removeUser(LoginModel user) {
        users.remove(user);
    }

    public boolean isUserExist(String username, String password) {
        return users.stream()
                .anyMatch(u -> u.getUsername().equals(username) && u.getPassword().equals(password));
    }

    public boolean isEmailExist(String email) {
        return users.stream()
                .anyMatch(u -> u.getEmail().equals(email));
    }

    public List<LoginModel> getUsers() {
        return users;
    }
}