package com.pmg.mymusictaste.service;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.SongRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepo;

    @Override
    public Page<Song> getSongList(Pageable pageInfo) {
        Page<Song> songList = songRepo.findAll(pageInfo);
        return songList;
    }

    @Override
    public void saveSong(Song song) {
        songRepo.save(song);
    };

}