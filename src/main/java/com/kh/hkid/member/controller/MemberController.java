package com.kh.hkid.member.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public String insertMember(Member m, HttpSession session) {
    	String encPwd = bcryptPasswordEncoder.encode(m.getMemberPwd());
    	m.setMemberPwd(encPwd);
    	System.out.println(m);
    	int result = memberService.insertMember(m);
    	
    	if(result > 0) {
    		session.setAttribute("alertMsg", "성공적으로 회원가입이 완료되었습니다.");
    		return "redirect:/loginForm.me";
    	} else {
    		session.setAttribute("alertMsg", "회원가입에 실패하였습니다.");
    		return "redirect:loginForm.me";
    	}
    }
    
    // 로그인
    @PostMapping("login.me")
    public String loginMember(Member m, HttpSession session, Model model, String saveId, HttpServletResponse response) {
    	System.out.println(m);
    	Member loginMember = memberService.loginMember(m);
    	System.out.println(loginMember);
    	if(loginMember == null || !bcryptPasswordEncoder.matches(m.getMemberPwd(), loginMember.getMemberPwd())) {
    		session.setAttribute("alertMsg", "로그인 정보에 맞는 아이디가 존재하지 않습니다.");
    		return "redirect:/loginForm.me";
    	} else {
    		Cookie ck = new Cookie("saveId", loginMember.getMemberId());
    		if(saveId == null) {
    			ck.setMaxAge(0); // 쿠키의 유효기간 설정
    		}
    		response.addCookie(ck);
    		
    		session.setAttribute("loginMember", loginMember);
    		if(loginMember.getIsAdmain().equals('N')) {
    			return "redirect:/";
    		} else {
    			return "redirect:/product.ad";
    		}
    		
    	}
    }
}
