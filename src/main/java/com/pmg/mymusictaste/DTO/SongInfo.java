package com.pmg.mymusictaste.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SongInfo {

    private String title;
    private String type;
    private String singer;
    private String thumbnail;
    private String youtubeId;

}
