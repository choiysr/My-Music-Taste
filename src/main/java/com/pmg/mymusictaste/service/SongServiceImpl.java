package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
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
        System.out.println("pageInfo > " + pageInfo);
        Page<Song> songList = songRepo.findAll(pageInfo);
        return songList;
    }

    @Override
    public void saveSong(Song song) {
        songRepo.save(song);
    }

    @Override
    public void saveAllSong(List<Song> list){
        //List<Song> list1 = songRepo.saveAll(list);
    }
        

}