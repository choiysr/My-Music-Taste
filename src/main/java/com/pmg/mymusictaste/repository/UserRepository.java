package com.pmg.mymusictaste.repository;

import java.util.List;

import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    

    @Query("SELECT PLAYLIST FROM USER WHERE USERID={user}")
    List<Playing> findPlaylistByUserid(User user);
    //List<Playing> findAllByUserid(String userid);
}