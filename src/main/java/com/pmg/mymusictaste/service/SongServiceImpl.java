package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.SongRepository;
import com.pmg.mymusictaste.util.MelonTarget;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SongServiceImpl implements SongService {

    private final SongRepository songRepo;

    @Override
    public void saveSongList(List<Song> list) {
        songRepo.saveAll(list);
    }

    @Override
    public Song getSongById(Long sid) {
        return songRepo.findById(sid).orElse(null);
    }

    @Override
    public Page<Song> getSongListByType(int startPage, int pageAmount, MelonTarget type) {
        // ranking 순으로 가져와야 맞지만, 어차피 insert될때 랭킹 순서대로되므로
        // (=auto increament되는 sid 순서대로 되므로) pk기준으로 가져오는 것이 효율적
        // 페이징은 0부터 시작이므로 startPage-1
        Pageable page = PageRequest.of(startPage - 1, pageAmount, Sort.Direction.ASC, "sid");
        Page<Song> songList = songRepo.findAllByType(type, page);
        return songList;
    }

    @Override
    public List<Song> deleteByType(MelonTarget type) {
        return songRepo.deleteByType(type);
    }

}