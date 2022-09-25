package com.kolvzaki.simpleweb.service;

import com.kolvzaki.simpleweb.model.Menu;
import com.kolvzaki.simpleweb.model.Role;
import com.kolvzaki.simpleweb.model.dto.RoleMenu;
import com.kolvzaki.simpleweb.repository.MenuRepository;
import com.kolvzaki.simpleweb.repository.RoleMenuRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private RoleMenuRepository roleMenuRepository;

    public List<Menu> getRawMenu(List<Role> Roles){
        List<RoleMenu> roleMenus = roleMenuRepository.findAllByRoleIn(Roles);
        return roleMenus.stream().map(RoleMenu::getMenu).collect(Collectors.toList());
    }
}
