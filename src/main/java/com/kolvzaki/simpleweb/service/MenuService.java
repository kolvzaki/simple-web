package com.kolvzaki.simpleweb.service;

import com.kolvzaki.simpleweb.model.Menu;
import com.kolvzaki.simpleweb.model.Role;
import com.kolvzaki.simpleweb.model.dto.MenuQuery;
import com.kolvzaki.simpleweb.model.dto.RoleMenu;
import com.kolvzaki.simpleweb.model.dto.RolesMenu;
import com.kolvzaki.simpleweb.repository.MenuRepository;
import com.kolvzaki.simpleweb.repository.RoleMenuRepository;
import com.kolvzaki.simpleweb.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MenuService {

    @Resource
    private MenuRepository menuRepository;

    @Resource
    private RoleMenuRepository roleMenuRepository;

    @Resource
    private RoleRepository roleRepository;

    public List<Menu> getRawMenu(final List<Role> Roles) {
        List<RoleMenu> roleMenus = roleMenuRepository.findAllByRoleIn(Roles);
        return roleMenus.stream().map(RoleMenu::getMenu).collect(Collectors.toList());
    }

    public List<Menu> queryRawMenu(final MenuQuery menuQuery) {
        List<Integer> menuIds;
        List<Menu> result = new ArrayList<Menu>();
        List<Menu> filterResult;
//        List<RoleMenu> roleMenus = roleMenuRepository.findAll();
        List<Menu> menus = menuRepository.findAll();
        if (!CollectionUtils.isEmpty(menuQuery.getRoles())) {
            List<RoleMenu> queryRoleMenus = roleMenuRepository.findByRole_IdIn(menuQuery.getRoles());
//            List<RoleMenu> queryRoleMenus = roleMenus.stream().filter(item -> menuQuery.getRoles().contains(item.getRole().getId())).collect(Collectors.toList());
            menuIds = queryRoleMenus.stream().map(item -> item.getMenu().getId()).collect(Collectors.toList());
            filterResult = menus.stream()
                    .filter(item -> menuIds.contains(item.getId()))
                    .filter(item -> item.getName().toLowerCase().contains(menuQuery.getMenuName()))
                    .collect(Collectors.toList());
        } else {
            filterResult = menus
                    .stream()
                    .filter(item -> item.getName().toLowerCase().contains(menuQuery.getMenuName()))
                    .collect(Collectors.toList());
        }
        for (Menu item : filterResult) {
            if (!ObjectUtils.isEmpty(item.getPid())) {
                result.addAll(menus.stream().filter(e -> e.getId().equals(item.getPid())).collect(Collectors.toList()));
            }
        }
        result.addAll(filterResult);
        result = result.stream().distinct().collect(Collectors.toList());
        return result;
    }

    public List<Role> queryMenuRoles(final Integer menuId){
        List<RoleMenu> roleMenus = roleMenuRepository.findByMenu_Id(menuId);
        List<Integer> roleIds = roleMenus.stream().map(item->item.getRole().getId()).collect(Collectors.toList());
        return roleRepository.findAllById(roleIds);
    }

    public void saveMenusRole(final RolesMenu rolesMenu){
        roleMenuRepository.deleteAllByMenu_Id(rolesMenu.getMenuId());
        List<RoleMenu> saveBatch = new ArrayList<>();
        Menu m = new Menu(rolesMenu.getMenuId());
        rolesMenu.getMenuRoles().forEach(r-> saveBatch.add(new RoleMenu(0,m,r)));
        roleMenuRepository.saveAll(saveBatch);
    }

    public void createMenuItem(final Menu menu){
        menu.setCreatedTime(new Date());
        menuRepository.save(menu);
    }

    public void updateMenuItem(final Menu menu){
        menu.setCreatedTime(new Date());
        menuRepository.save(menu);
    }
    public void deleteMenuItem(final Integer menuId){
        roleMenuRepository.deleteAllByMenu_Id(menuId);
        roleMenuRepository.deleteAllByMenu_Pid(menuId);
        menuRepository.deleteById(menuId);
        menuRepository.deleteAllByPid(menuId);
    }

    public void deleteBatchMenuItem(final List<Integer> menuIds){
        roleMenuRepository.deleteAllByMenu_IdIn(menuIds);
        menuRepository.deleteAllById(menuIds);
    }
}
