package com.pmg.mymusictaste.service;

import com.pmg.mymusictaste.domain.Member;

public interface MemberService {

  public Member findByEmail(String email);
  

}