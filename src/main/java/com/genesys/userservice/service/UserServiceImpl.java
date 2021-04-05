package com.genesys.userservice.service;

import com.genesys.userservice.exception.EmailAlreadyExistsException;
import com.genesys.userservice.exception.UsernameAlreadyExistsException;
import com.genesys.userservice.model.User;
import com.genesys.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        if(userRepository.existsByUsername(user.getUsername())){
            throw new UsernameAlreadyExistsException(
                    String.format("Error! username %s already exists, use another one, please", user.getUsername()));
        }
        if(userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException(
                    String.format("Error! Email %s already exists, Specify another one please", user.getEmail()));
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();

        if (allUsers == null || allUsers.isEmpty()) {
            return null;
        }
        return allUsers;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
