package com.capgemini.user_service.controller;

import com.capgemini.user_service.model.Role;
import com.capgemini.user_service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("roles")
    public List<Role> getRoles(){
        return roleService.getRoles();
    }

    @PostMapping("/saveRole")
    public void saverole(@RequestBody Role role){
        roleService.saveRole(role);
    }
}
