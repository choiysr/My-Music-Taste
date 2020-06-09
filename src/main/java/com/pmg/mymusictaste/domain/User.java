package com.pmg.mymusictaste.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userid;
    private String password;
    private String nickname;

    @OneToMany
    @JoinColumn(name = "user_userid")
    private List<Playing> playing = new ArrayList<>();


    
}