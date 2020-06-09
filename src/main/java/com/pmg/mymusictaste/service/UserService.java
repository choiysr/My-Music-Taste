package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.User;

public interface UserService {
  

  public List<Playing> getPlayList(User user);
}