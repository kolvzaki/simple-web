package com.kolvzaki.simpleweb.controller;

import com.kolvzaki.simpleweb.model.Menu;
import com.kolvzaki.simpleweb.model.Role;
import com.kolvzaki.simpleweb.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuController {

    @Resource
    private MenuService menuService;

    @PostMapping("/raw")
    public List<Menu> getRawMenu(@RequestBody List<Role>Roles){
        return menuService.getRawMenu(Roles);
        //return new ArrayList<>();
    }
}
