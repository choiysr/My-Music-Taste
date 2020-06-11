package com.pmg.mymusictaste.domain;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.pmg.mymusictaste.util.MelonTarget;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Song {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long sid;
  private Integer ranking;

  @Enumerated(EnumType.STRING)
  private MelonTarget type;
  private String title;
  private String singer;
  private String thumbnail;
  private String youtubeId;
  

}