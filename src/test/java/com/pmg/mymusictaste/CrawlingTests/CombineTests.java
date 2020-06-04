package com.pmg.mymusictaste.CrawlingTests;

import java.util.ArrayList;
import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.service.SongService;
import com.pmg.mymusictaste.util.MelonCrawler;
import com.pmg.mymusictaste.util.YoutubeCrawler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;

@SpringBootTest
public class CombineTests {

    @Setter(onMethod_ = {@Autowired})
    private SongService sServ;


    @Test
    public void getYoutubeVideoIdByMelonTest(){

        MelonCrawler melon = new MelonCrawler();
        List<SongInfo> list = melon.getMelonCrawlingList("https://www.melon.com/chart/index.htm");
        YoutubeCrawler youtube = new YoutubeCrawler(list);
        List<SongInfo> finalList = youtube.useYoutubeAPI();
        Song songs = null;

        List<Song> songList = new ArrayList<Song>();
        // 이후에 finalList를 레파지토리를 이용해 save하면 DB에 저장됩니다.
        // 근데 이게 일일이 리스트 돌면서 객체 하나하나씩 save하는게 아니라 
        // 리스트 자체를 파라미터로 넘겨주면 저장되는 방법도 있거든요? 
        // 그거 구글링해서 한번 알아봐서 적용해주세용(저도 안해봤어요 )

        // ex.
        for(SongInfo song : list) {
            System.out.println("song gettitle : "+song.getTitle());
            if(song.getTitle()!=null||song.getTitle()!="") {
                sServ.saveSong(Song.builder().title(song.getTitle()).singer(song.getSinger()).thumbnail(song.getThumbnail()).youtubeId(song.getYoutubeId()).build());
            } else {
                System.out.println("get error========!");
            }
            // sServ.saveSong(Song.builder().title(song.getTitle()).singer(song.getSinger()).thumbnail(song.getThumbnail()).youtubeId(song.getYoutubeId()).build());
            // 이렇게하면 리스트 돌면서 하나하나씩 db에 저장
            // 넣을때마다 트랜잭션 발생 
        }
        

        //sRepo.saveAll(finalList);
        // 위처럼하면 리스트 통째로 저장(트랜잭션 1개)
        // 근데 saveAll을 구현해야하는가 아마 그럴거에요. 그걸 구글링해서 찾아주시면 됨! saveAll이 작동하도록 
        

        //SongInfo List를 Song에 담기

        for(SongInfo si : finalList){
            songs = new Song();
            songs.setSinger(si.getSinger());
            songs.setTitle(si.getTitle());
            songs.setThumbnail(si.getThumbnail());
            songs.setYoutubeId(si.getYoutubeId());
            songList.add(songs);
        }
        for(Song s : songList){
            System.out.println("change Song List > " + s);
        }

        //기능구현을 해야 한다면 수정
        //sServ.saveAllSong(songList);
        

        

    }

}