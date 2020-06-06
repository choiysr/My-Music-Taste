package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Song;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {

    // 테스트용. 
    public Page<Song> getSongList(Pageable pageInfo);
    

    public Page<Song> findByType(int startPage, int amount, String type);
    
    public void saveSong(Song song);
    public void saveAllSong(List<Song> list);

}