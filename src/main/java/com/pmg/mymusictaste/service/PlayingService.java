package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;

public interface PlayingService {

  //Page<Playlist> findAllByUserId(String user, Pageable page);
  
  public List<Playing> addMusic(List<Playing> playList);

  /* public Page<Playing> getPlayingByUser(int startPage, int amount, User user); */

  public List<Playing> getMemberPlayList(Member member);

  public void deletePlayingList(List<Long> pids);


}