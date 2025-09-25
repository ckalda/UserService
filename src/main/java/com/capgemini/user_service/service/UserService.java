package com.capgemini.user_service.service;

import com.capgemini.user_service.exceptionHandler.UserNotFoundException;
import com.capgemini.user_service.model.Role;
import com.capgemini.user_service.model.User;
import com.capgemini.user_service.repository.RoleRepo;
import com.capgemini.user_service.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;
    private RoleRepo roleRepo;

    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    public List<User> getUsers(){
        return userRepo.findAll();
    }

    public User getUserById(Long id){
        return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Given " + id + " is not present"));
    }

    public User saveUser(User user){
        Role role = null;
        if(user.getRole().getRoleName().equals("Doctor")) {
            role = roleRepo.findById(1).orElseThrow(() -> new RuntimeException("Role not found"));
        } else if (user.getRole().getRoleName().equals("Patient")) {
            role = roleRepo.findById(2).orElseThrow(() -> new RuntimeException("Role not found"));
        } else if (user.getRole().getRoleName().equals("Admin")) {
            role = roleRepo.findById(3).orElseThrow(() -> new RuntimeException("Role not found"));
        } else {
            new RuntimeException("Role not found");
        }
        user.setRole(role);
        userRepo.save(user);
        return user;
    }

    public void updateUser(User user){
        Role role = null;
        if(user.getRole().getRoleName().equals("Doctor")) {
            role = roleRepo.findById(1).orElseThrow(() -> new RuntimeException("Role not found"));
        } else if (user.getRole().getRoleName().equals("Patient")) {
            role = roleRepo.findById(2).orElseThrow(() -> new RuntimeException("Role not found"));
        } else if (user.getRole().getRoleName().equals("Admin")) {
            role = roleRepo.findById(3).orElseThrow(() -> new RuntimeException("Role not found"));
        } else {
            new RuntimeException("Role not found");
        }
        user.setRole(role);
        userRepo.save(user);
    }
}
