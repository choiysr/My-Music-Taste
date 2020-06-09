package com.pmg.mymusictaste.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Playlist
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Playing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private User user;

    private String title;
    private String singer;
    private String youtubeid;



    
    
}