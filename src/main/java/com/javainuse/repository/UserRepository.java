package com.javainuse.repository;


import com.javainuse.model.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;
import java.util.List;


public interface UserRepository extends JpaRepository<Driver,Long> {
   // List<Driver> findAll();


  //  @Query("SELECT Driver FROM Driver d WHERE d.username = :username")
//    Driver findByUsername(@Param("username") String username);
    Driver findByUsername(String username);
//
//    @Modifying
//    @Query("UPDATE Driver d SET d.state = :state WHERE d.username = :name")
//    String updateState(@Param("state") String state, @Param("name") String name);
    }
