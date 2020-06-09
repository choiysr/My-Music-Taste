package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;

public interface MemberService {
  

  public List<Playing> getPlayList(Member member);
}