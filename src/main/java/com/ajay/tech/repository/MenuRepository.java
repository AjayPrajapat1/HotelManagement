package com.ajay.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajay.tech.entity.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

}
