package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;

public interface PlayingService {

  public List<Playing> addMusic(List<Playing> playList);

  public List<Playing> getMemberPlayList(Member member);

  public void deletePlayingList(List<Long> pids);


}