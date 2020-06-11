package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Song;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {

    public Song getSongById(Long sid);
    public Page<Song> getSongListByType(int startPage, int amount, String type);
    public void saveSong(Song song);
    public void saveAllSong(List<Song> list);

}