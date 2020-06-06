package com.pmg.mymusictaste.RepositoryTests;

import com.pmg.mymusictaste.service.SongService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class SongRepoTests {


    @Autowired
    SongService sserv;

    @Test
    public void songRepoTest(){

        int startPage = 0;
        int amount = 50;
        Pageable page = PageRequest.of(startPage-1, amount, Sort.Direction.ASC, "ranking");
        

    }

}