package com.pmg.mymusictaste.repository;

import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayingRepository extends JpaRepository<Playing, Long>{

    Page<Playing> findAllByUser(User user, Pageable page);
    Integer countByUser(User user); 

}