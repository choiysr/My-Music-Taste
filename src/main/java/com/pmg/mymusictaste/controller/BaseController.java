package com.pmg.mymusictaste.controller;

import javax.servlet.http.HttpSession;

import com.pmg.mymusictaste.config.auth.dto.SessionMember;
import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.service.MemberService;
import com.pmg.mymusictaste.service.PlayingService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BaseController {

  private final HttpSession httpSession;

  private final PlayingService pserv;
  private final MemberService mserv;
  


  @GetMapping("/")
  public String mappedUrl(Model model) {
    SessionMember member = (SessionMember) httpSession.getAttribute("user");
    if (member != null) {
        model.addAttribute("userName", member.getName());
        model.addAttribute("userEmail", member.getEmail());
        model.addAttribute("userImg", member.getPicture());
        model.addAttribute("userPlaylist", pserv.getMemberPlayList(mserv.findByEmail(member.getEmail())));
    }
    return "index";
  }

  
}