package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Song;

public interface CrawlingService {

    public void saveSongList(List<Song> list);
    
}