package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.repository.UserRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
  
  private final UserRepository userRepo;

  @Override
  public List<Playing> getPlayList(String userId){
    return userRepo.findAllByUserId(userId);
  }
}