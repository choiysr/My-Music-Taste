package com.pmg.mymusictaste.repository;

import com.pmg.mymusictaste.domain.Playlist;
import com.pmg.mymusictaste.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

  Page<Playlist> findAllByUser(User user, Pageable page);
    
}