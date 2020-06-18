package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.repository.PlayingRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayingServiceImpl implements PlayingService{

  private final PlayingRepository repository;

  @Override
  public List<Playing> addMusic(List<Playing> playList){
     return repository.saveAll(playList);
  }

  @Override
  public List<Playing> getMemberPlayList(Member member){
    return repository.findAllByMember(member);
  }

  @Override
  public void deletePlayingList(List<Long> pids) {
   repository.deleteAllByIdInQuery(pids);
  }

  

}