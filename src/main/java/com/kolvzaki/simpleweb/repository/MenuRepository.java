package com.kolvzaki.simpleweb.repository;

import com.kolvzaki.simpleweb.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {

}
