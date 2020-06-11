package com.pmg.mymusictaste.DTO;

import java.util.ArrayList;
import java.util.List;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.util.MelonTarget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongInfo {

    private Integer ranking;
    private String title;
    private MelonTarget type;
    private String singer;
    private String thumbnail;
    private String youtubeId;

    public static List<Song> toSongList(List<SongInfo> songInfoList){
        List<Song> songList = new ArrayList<>();
        for(SongInfo songInfo : songInfoList){
            songList.add(Song.builder()
            .singer(songInfo.getSinger())
            .title(songInfo.getTitle())
            .ranking(songInfo.getRanking())
            .type(songInfo.getType())
            .thumbnail(songInfo.getThumbnail())
            .youtubeId(songInfo.getYoutubeId())
            .build());
        }
        return songList;
    }

}
