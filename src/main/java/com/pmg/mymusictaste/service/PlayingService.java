package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.User;

import org.springframework.data.domain.Page;

public interface PlayingService {

  //Page<Playlist> findAllByUserId(String user, Pageable page);
  
  public void addMusic(List<Playing> playList);

  /* public Page<Playing> getPlayingByUser(int startPage, int amount, User user); */

  public List<Playing> getUserPlayList(User user);


}