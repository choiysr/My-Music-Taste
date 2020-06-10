package com.pmg.mymusictaste.service;

import java.util.List;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.repository.PlayingRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayingServiceImpl implements PlayingService{

  private final PlayingRepository repository;

  //Page<Song> findAllByUserId(String user, Pageable page){}

  @Override
  public List<Playing> addMusic(List<Playing> playList){
     return repository.saveAll(playList);
  }

  //String user, Pageable page
  /* @Override
  public Page<Playing> getPlayingByUser(int startPage, int amount, User user){
      // ranking 순으로 가져와야 맞지만, 어차피 insert될때 랭킹 순서대로되므로
      // (=auto increament되는 sid 순서대로 되므로) pk기준으로 가져오는 것이 효율적
      // 페이징은 0부터 시작이므로 startPage-1 
      Pageable page = PageRequest.of(startPage-1, amount, Sort.Direction.ASC, "pid");
      Page<Playing> songList = repository.findAllByUser(user,page);
      return songList;
  }
 */
  @Override
  public List<Playing> getMemberPlayList(Member member){
    return repository.findAllByMember(member);
  }

}