package com.capgemini.user_service.service;

import com.capgemini.user_service.model.Role;
import com.capgemini.user_service.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private RoleRepo roleRepo;

    @Autowired
    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<Role> getRoles(){
        return roleRepo.findAll();
    }

    public void saveRole(Role role){
        roleRepo.save(role);
    }
}
