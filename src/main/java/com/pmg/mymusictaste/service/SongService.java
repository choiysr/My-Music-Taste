package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.domain.Song;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {

    public Page<Song> getSongList(Pageable pageInfo);

    public void saveSong(Song song);

    public void saveAllSong(List<Song> list);

}