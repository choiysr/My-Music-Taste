package com.pmg.mymusictaste.repository;

import com.pmg.mymusictaste.domain.Playlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

    
    
}