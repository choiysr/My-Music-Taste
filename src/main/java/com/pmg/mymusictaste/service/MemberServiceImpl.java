package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.repository.MemberRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
  
  private final MemberRepository memberRepo;

  @Override
  public List<Playing> getPlayList(Member member){
    List<Playing> list = null;
    //return memberRepo.findAllByUserid(user.getUserid());
    return list;
  }
}