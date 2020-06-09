package com.pmg.mymusictaste.repository;

import java.util.List;

import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayingRepository extends JpaRepository<Playing, Long>{

    //Page<Playing> findAllByUser(User user, Pageable page);

    List<Playing> findAllByUser(User user);


}