package com.pmg.mymusictaste.controller;

import javax.servlet.http.HttpSession;

import com.pmg.mymusictaste.config.auth.dto.SessionMember;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BaseController {

  private final HttpSession httpSession;

  @GetMapping("/")
  public String mappedUrl(Model model) {
    SessionMember member = (SessionMember) httpSession.getAttribute("user");
    if (member != null) {
        model.addAttribute("userName", member.getName());
        model.addAttribute("userEmail", member.getEmail());
        model.addAttribute("userImg", member.getPicture());
    }
    return "index";
  }

  
}