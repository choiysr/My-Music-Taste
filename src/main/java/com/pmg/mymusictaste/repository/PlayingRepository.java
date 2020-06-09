package com.pmg.mymusictaste.repository;

import java.util.List;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayingRepository extends JpaRepository<Playing, Long>{

    List<Playing> findAllByMember(Member member);
    Integer countByMember(Member member); 

}