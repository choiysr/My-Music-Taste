package com.pmg.mymusictaste.ServiceTests;

import java.util.List;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.repository.MemberRepository;
import com.pmg.mymusictaste.repository.PlayingRepository;
import com.pmg.mymusictaste.service.PlayingService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class PlayingServiceTest {

  @Setter(onMethod_ = {@Autowired})
  private PlayingService pServ;

  @Autowired
  private MemberRepository mRepo;

  @Autowired
  private PlayingRepository pRepo;


  @Test
  public void insertPlayListTest(){
    
    // System.out.println("####[playList Service Test]");
    // Member member = new Member();
    // Playing playList = new Playing();

    // member = Member.builder().userid("hb").nickname("hyunbin").password("1111").build();
    // playList = Playing.builder().title("에잇").singer("아이유").member(member).youtubeid("!@#SDFASF11").build();
    //pServ.addMusic(playList);

    Member test = mRepo.findByEmail("choiysr@pmgroup.co.kr").orElse(null);
    pRepo.save(Playing.builder().member(test).singer("남진").title("금요일에만나요").youtubeid("youtubeid234").build());
    pRepo.findAllByMember(test);


  }

  @Test
  public void getPlayList(){
    Member test = mRepo.findByEmail("choiysr@pmgroup.co.kr").orElse(null);
    List<Playing> list = pRepo.findAllByMember(test);
    for(Playing p: list ){
      System.out.println(p);
    }
  } 
  

  @Test
  public void countTest(){
    Member member = mRepo.findById("userid").orElse(null);
    // List<Playing> playlist = new ArrayList<>();
    // playlist.add(Playing.builder().singer("singer").title("title").user(user).youtubeid("youtubeid").build());
    // playlist.add(Playing.builder().singer("singer12").title("ti123tle").user(user).youtubeid("you123tubeid").build());
    // playlist.add(Playing.builder().singer("sinasdf").title("ti123tlasdfe").user(user).youtubeid("you123tuasdfbeid").build());
    // pRepo.saveAll(playlist);
    log.info( pRepo.countByMember(member)+"");
  }
  
}