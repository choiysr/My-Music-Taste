package com.pmg.mymusictaste.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sid;
  private @NonNull String title;
  private @NonNull String singer;
  private @NonNull String thumbnail;
  private @NonNull String youtubeId;

}