package com.pmg.mymusictaste.repository;

import com.pmg.mymusictaste.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

    
}