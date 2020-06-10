package com.pmg.mymusictaste.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    MEMBER("ROLE_MEMBER", "일반 사용자");

    private final String key;
    private final String title;
    
}