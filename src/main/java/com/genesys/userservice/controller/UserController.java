package com.genesys.userservice.controller;

import com.genesys.userservice.exception.EmailAlreadyExistsException;
import com.genesys.userservice.exception.UserBadRequestException;
import com.genesys.userservice.exception.UsernameAlreadyExistsException;
import com.genesys.userservice.model.User;
import com.genesys.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        try {
            if (userService.saveUser(user) != null) {
                return ResponseEntity.created(new URI("/users/" + user.getId())).build();
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (UsernameAlreadyExistsException e) {
            throw new UserBadRequestException(e.getMessage());
        } catch (EmailAlreadyExistsException e) {
            throw new UserBadRequestException(e.getMessage());
        } catch (Exception e) {
            throw new UserBadRequestException(e.getMessage());
        }
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();

        if (users == null || users.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getOneUser(@PathVariable("username") String username) {
        User user = userService.getUserByUsername(username);

        if (user == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(user);
    }
}
