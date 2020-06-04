package com.pmg.mymusictaste.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private String title;
  private String singer;
  private String thumbnail;
  private String youtubeId;

}