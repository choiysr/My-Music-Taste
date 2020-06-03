package com.pmg.mymusictaste.repository;


import lombok.*;

@Data
@NoArgsConstructor
public class Song {

  private @NonNull String Name;
  private @NonNull String artist;
  private @NonNull String sumnail;

}