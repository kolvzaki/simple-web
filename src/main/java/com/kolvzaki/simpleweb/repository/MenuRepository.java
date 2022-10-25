package com.kolvzaki.simpleweb.repository;

import com.kolvzaki.simpleweb.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {
    @Modifying
    void deleteAllByPid(Integer pid);
}
