package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.util.MelonTarget;

import org.springframework.data.domain.Page;

public interface SongService {

    public void saveSongList(List<Song> list);
    public Song getSongById(Long sid);
    public Page<Song> getSongListByType(int startPage, int amount, MelonTarget type);
    public List<Song> deleteByType(MelonTarget type);
    
}