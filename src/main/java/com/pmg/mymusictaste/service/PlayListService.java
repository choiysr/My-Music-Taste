package com.pmg.mymusictaste.service;

import com.pmg.mymusictaste.domain.Playlist;
import com.pmg.mymusictaste.domain.User;

import org.springframework.data.domain.Page;

public interface PlayListService {

  //Page<Playlist> findAllByUserId(String user, Pageable page);
  
  public void addMusic(Playlist playlist);

  public Page<Playlist> getPlayListByUser(int startPage, int amount, User UserId);


}