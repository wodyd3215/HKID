package com.kh.hkid.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.hkid.member.service.MemberService;

@Controller
public class MemberController {
	private final MemberService memberService;
	
	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping("loginForm.me")
	public String loginForm() {
		return "member/loginForm";
	}
	
	@GetMapping("searchIdForm.me")
	public String searchId() {
		return "member/searchMemberId";
	}
	
	@GetMapping("searchPwdForm.me")
	public String searchPwd() {
		return "member/searchMemberPwd";
	}
	
	@GetMapping("changePwdForm.me")
	public String changePwd() {
		return "member/changeMemberPwd";
	}

    @GetMapping("personal.me")
    public String personalForm() {
	    return "member/personalPage";
    }
    
    @GetMapping("agreeForm.me")
    public String agreeForm() {
    	return "member/agreeForm";
    }
    
    @GetMapping("enrollForm.me")
    public String enrollForm() {
    	return "member/enrollForm";
    }
    
    @GetMapping("myDiary.me")
    public String myDiary() {
    	return "member/myDiaryPage";
    }
}
