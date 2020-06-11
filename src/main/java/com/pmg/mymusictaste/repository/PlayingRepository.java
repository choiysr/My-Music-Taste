package com.pmg.mymusictaste.repository;

import java.util.List;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayingRepository extends JpaRepository<Playing, Long>{

    List<Playing> findAllByMember(Member member);
    Integer countByMember(Member member); 

    @Modifying
    @Query("delete from Playing p where p.pid in :pids")
    void deleteAllByIdInQuery(@Param("pids") List<Long> pids);
    

}