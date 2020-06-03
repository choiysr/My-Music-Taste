package com.pmg.mymusictaste.repository;

import com.pmg.mymusictaste.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
  
}