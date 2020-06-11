package com.pmg.mymusictaste.ServiceTests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.service.CrawlingService;
import com.pmg.mymusictaste.util.MelonTarget;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;

@SpringBootTest
public class CrawlingServiceTest {

    @Setter(onMethod_ = { @Autowired })
    private CrawlingService crawlServ;


    @Test
    public void melonTargetTest(){
        System.out.println(MelonTarget.valueOf("DAILY"));
    }

    @Test
    public void insertSongDatasAfterCrawling() {

        List<SongInfo> targetList = new ArrayList<>();
        IntStream.range(0, 5).forEach(i -> {
            targetList.add(
                SongInfo.builder()
                .title("title" + i)
                .singer("singer" + i)
                .ranking(i)
                .thumbnail("thumbnail" + i)
                .type(MelonTarget.DAILY).build());
        });

        List<Song> finalList = SongInfo.toSongList(targetList);
        for(Song song : finalList) {
            System.out.println(song);
        }


        crawlServ.saveSongList(finalList);

    }

}