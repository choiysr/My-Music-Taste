package com.pmg.mymusictaste.repository;


import lombok.*;

@Data
@NoArgsConstructor
public class Song {

  private @NonNull String title;
  private @NonNull String singer;
  private @NonNull String thumbnail;

}