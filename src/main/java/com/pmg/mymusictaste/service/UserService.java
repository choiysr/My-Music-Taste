package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Playing;

public interface UserService {
  

  public List<Playing> getPlayList(String userId);
}