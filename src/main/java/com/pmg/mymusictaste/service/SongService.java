package com.pmg.mymusictaste.service;

import com.pmg.mymusictaste.domain.Song;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SongService {

    public Page<Song> getSongList(Pageable pageInfo);

}