package com.kolvzaki.simpleweb.controller;

import com.kolvzaki.simpleweb.model.Menu;
import com.kolvzaki.simpleweb.model.Role;
import com.kolvzaki.simpleweb.model.dto.MenuQuery;
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

    @PostMapping("/query")
    public List<Menu> queryRawMenu(@RequestBody MenuQuery menuQuery){
        return menuService.queryRawMenu(menuQuery);
    }

    @GetMapping("/queryMenuRole")
    public List<Role> queryMenuRole(@RequestParam Integer menuId){
        return menuService.queryMenuRoles(menuId);
    }
}
