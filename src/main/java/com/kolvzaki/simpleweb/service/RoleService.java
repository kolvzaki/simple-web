package com.kolvzaki.simpleweb.service;

import com.kolvzaki.simpleweb.model.Role;
import com.kolvzaki.simpleweb.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    public List<Role> fetchRoles(){
        return roleRepository.findAll();
    }
}
