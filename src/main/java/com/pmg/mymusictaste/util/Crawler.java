package com.pmg.mymusictaste.util;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.repository.SongRepository;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;

public class Crawler {
  
  @Setter(onMethod_ = {@Autowired})
    private SongRepository sRepo;

  public void putMusicList(String url){
    MelonCrawler melon = new MelonCrawler();
    List<SongInfo> list = melon.getMelonCrawlingList("https://www.melon.com/chart/index.htm"); // url 
    YoutubeCrawler youtube = new YoutubeCrawler(list);
    List<SongInfo> finalList = youtube.useYoutubeAPI();
    
    // 이후에 finalList를 레파지토리를 이용해 save하면 DB에 저장됩니다.
    // 근데 이게 일일이 리스트 돌면서 객체 하나하나씩 save하는게 아니라 
    // 리스트 자체를 파라미터로 넘겨주면 저장되는 방법도 있거든요? 
    // 그거 구글링해서 한번 알아봐서 적용해주세용(저도 안해봤어요 )

    // ex.
    for(SongInfo song : finalList) {
        //sRepo.save(song);
         //The method save(S) in the type CrudRepository<Song,Long> is not applicable for the arguments
        // 이렇게하면 리스트 돌면서 하나하나씩 db에 저장
        // 넣을때마다 트랜잭션 발생 
    }
    //finalList = sRepo.saveAll(finalList);

    // sRepo.saveAll(finalList);
    // 위처럼하면 리스트 통째로 저장(트랜잭션 1개)
    // 근데 saveAll을 구현해야하는가 아마 그럴거에요. 그걸 구글링해서 찾아주시면 됨! saveAll이 작동하도록 
    
  }
}