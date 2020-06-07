package com.pmg.mymusictaste.repository;

import com.pmg.mymusictaste.domain.Song;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Page<Song> findAllByType(String type, Pageable page);

}