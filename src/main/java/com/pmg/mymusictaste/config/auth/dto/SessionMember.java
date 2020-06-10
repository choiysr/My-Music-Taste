package com.pmg.mymusictaste.config.auth.dto;

import java.io.Serializable;

import com.pmg.mymusictaste.domain.Member;

import lombok.Getter;
import lombok.ToString;

/**
 * SessionMember
 */
/* 기존 Member를 쓰지 않고 SessionMember를 dto로 만들어 사용하는 이유
   : Member 클래스는 Entity이기 때문에(다른 Entity와 관계가 형성될수 있기 때문에=>List<Playing>과 OneToMany) 
     직렬화 대상에 다른 entity까지 포함되니 성능이슈, 부수효과가 발생할 확률이 높음. 따라서 직렬화 기능을 가진 세션 Dto를 
     추가로 만드는 것이 좋음 */
@Getter
@ToString
public class SessionMember implements Serializable {

    private String name;
    private String email;
    private String picture;

    public SessionMember(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.picture = member.getPicture();
    }

    
}