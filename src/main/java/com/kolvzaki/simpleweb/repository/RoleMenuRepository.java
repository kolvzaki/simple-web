package com.kolvzaki.simpleweb.repository;

import com.kolvzaki.simpleweb.model.Role;
import com.kolvzaki.simpleweb.model.dto.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleMenuRepository extends JpaRepository<RoleMenu,Integer> {

    List<RoleMenu> findAllByRoleIn(List<Role> Roles);

    List<RoleMenu> findByRole_IdIn(List<Integer> Roles);

    List<RoleMenu> findByMenu_Id(Integer menuId);
}
