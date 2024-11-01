package com.kh.hkid.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.hkid.member.service.MemberService;

@Controller
public class MemberController {
	private final MemberService memberService;
   
   @Autowired
   public MemberController(MemberService memberService) {
      this.memberService = memberService;
   }
   
   @RequestMapping("personal.me")
   public String personalForm() {
	   return "personal/personalPage";
   }
}
