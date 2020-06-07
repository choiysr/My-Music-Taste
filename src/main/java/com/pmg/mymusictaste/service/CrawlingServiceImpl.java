package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.SongRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CrawlingServiceImpl implements CrawlingService {

    private final SongRepository songRepo;

    @Override
    public void saveSongList(List<Song> list) {
        songRepo.saveAll(list);
    }
    
}