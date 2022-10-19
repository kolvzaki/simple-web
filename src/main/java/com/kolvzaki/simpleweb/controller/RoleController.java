package com.kolvzaki.simpleweb.controller;

import com.kolvzaki.simpleweb.model.Role;
import com.kolvzaki.simpleweb.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @GetMapping("/fetch")
    public List<Role> fetchRoles(){
        return roleService.fetchRoles();
    }
}
