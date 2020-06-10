package com.pmg.mymusictaste.repository;

import java.util.Optional;

import com.pmg.mymusictaste.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String>{
    
    Optional<Member> findByEmail(String email);

}