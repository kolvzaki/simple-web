package com.kolvzaki.simpleweb.controller;

import com.kolvzaki.simpleweb.model.Menu;
import com.kolvzaki.simpleweb.model.Role;
import com.kolvzaki.simpleweb.model.dto.MenuQuery;
import com.kolvzaki.simpleweb.model.dto.RolesMenu;
import com.kolvzaki.simpleweb.service.MenuService;
import org.springframework.http.HttpStatus;
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

    //TODO: 分页
    @PostMapping("/query")
    public List<Menu> queryRawMenu(@RequestBody MenuQuery menuQuery){
        return menuService.queryRawMenu(menuQuery);
    }

    //TODO: 分页
    @GetMapping("/queryMenuRole")
    public List<Role> queryMenuRole(@RequestParam Integer menuId){
        return menuService.queryMenuRoles(menuId);
    }

    @PostMapping("/updateRoles")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMenuRoles(@RequestBody RolesMenu rolesMenu){
        menuService.saveMenusRole(rolesMenu);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMenuItem(@RequestBody Menu menu){
        menuService.createMenuItem(menu);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMenuItem(@RequestBody Menu menu){
        menuService.updateMenuItem(menu);
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMenuItem(@RequestParam Integer menuId){
        menuService.deleteMenuItem(menuId);
    }

    @DeleteMapping("/delete/batch")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBatchMenuItem(@RequestBody List<Integer> ids){
        menuService.deleteBatchMenuItem(ids);
    }
}
