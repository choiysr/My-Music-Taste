package com.pmg.mymusictaste.CrawlingTests;

import java.util.stream.IntStream;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.SongRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class insertTest {
 
  @Autowired
  SongRepository repo;

  @Test
  public void insertDummies() {

      // String[] strarr = {"oCkAUDJKa10", "DdUYiULhRSQ", "FVf-2DdFX80", "OFVlAvs0j4g", "Xw9kagBlXIo", "ATRsQu2vRJ4" , "ljzeYZdPFv4",  "u7bFrfAYWzA", "pEDwj6KyCjg" ,  "H3FLz4f-k5Y" }; 

      // IntStream.range(0,9).forEach(i-> {
      //     repo.save(Song.builder()
      //     .thumbnail("https://cdnimg.melon.co.kr/cm2/album/images/104/33/754/10433754_20200521162928_500.jpg/melon/resize/120/quality/80/optimize")
      //     .singer("가수"+i).title("제목"+i).type("DAILY").youtubeId(strarr[i]).build());
      // });
      
  }
}