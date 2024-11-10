package com.kh.hkid.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.member.service.MemberService;

@Controller
public class MemberController {
	private final MemberService memberService;
	private final BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@Autowired
	public MemberController(MemberService memberService, BCryptPasswordEncoder bcryptPasswordEncoder) {
		this.memberService = memberService;
		this.bcryptPasswordEncoder = bcryptPasswordEncoder;
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
    
    // 회원가입
    @PostMapping("insert.me")
    public String insertMember(Member m, HttpSession session, Model model) {
    	String encPwd = bcryptPasswordEncoder.encode(m.getMemberPwd());
    	m.setMemberPwd(encPwd);
    	System.out.println(m);
    	int result = memberService.insertMember(m);
    	
    	if(result > 0) {
    		session.setAttribute("alertMsg", "성공적으로 회원가입이 완료되었습니다.");
    		return "member/loginForm";
    	} else {
    		model.addAttribute("alertMsg", "회원가입에 실패하였습니다.");
    		return "member/loginForm";
    	}
    }
}
