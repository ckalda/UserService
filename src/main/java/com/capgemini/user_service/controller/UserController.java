package com.capgemini.user_service.controller;

import com.capgemini.user_service.exceptionHandler.UserNotFoundException;
import com.capgemini.user_service.model.User;
import com.capgemini.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public ResponseEntity<List<User>> users(){
        return ResponseEntity.ok(userService.getUsers());
    }
    @GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PatchMapping("/saveUser")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User savedUser = userService.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(savedUser).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }
}
