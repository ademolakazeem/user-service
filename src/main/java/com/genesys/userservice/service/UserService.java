package com.genesys.userservice.service;

import com.genesys.userservice.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserByUsername(String username);
}
