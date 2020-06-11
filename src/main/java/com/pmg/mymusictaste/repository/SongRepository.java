package com.pmg.mymusictaste.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.util.MelonTarget;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    Page<Song> findAllByType(MelonTarget type, Pageable page);

    @Transactional
    List<Song> deleteByType(MelonTarget type);

}