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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.hkid.common.template.Template;
import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
    		return "redirect:/loginForm.me";
    	}
    }
    
    // 로그인
    @PostMapping("login.me")
    public String loginMember(Member m, HttpSession session, String saveId, HttpServletResponse response) {
    	Member loginMember = memberService.loginMember(m);

    	if(loginMember == null || !bcryptPasswordEncoder.matches(m.getMemberPwd(), loginMember.getMemberPwd())) {
    		session.setAttribute("alertMsg", "로그인 정보에 맞는 아이디가 존재하지 않습니다."); 
    		return "redirect:/loginForm.me";
    	} else {
    		Cookie ck = new Cookie("saveId", loginMember.getMemberId());
    		System.out.println("쿠키:" + ck);
    		if(saveId == null) {
    			ck.setMaxAge(0); // 쿠키의 유효기간 설정
    		}
    		response.addCookie(ck);
    		
    		session.setAttribute("loginMember", loginMember);
    		if(loginMember.getIsAdmin().equals("N")) {
    			return "redirect:/";
    		} else {
    			return "redirect:/product.ad";
    		}
    		
    	}
    }
    
    // 로그아웃
    @GetMapping("logout.me")
    public String logoutMember(HttpSession session) {
    	session.removeAttribute("loginMember");
    	
    	return "redirect:/";
    }
    
    // 아이디 중복체크
    @PostMapping("idCheck.me")
    @ResponseBody
    public String idCheck(String checkId) {
    	System.out.println(checkId);
    	
    	int result = memberService.idCheck(checkId);
    	
    	System.out.println(result);
    	
    	if(result > 0) {
    		return "N";
    	} else {
    		return "Y";
    	}
    }
    
    // 닉네임 중복체크
    @PostMapping("nickCheck.me")
    @ResponseBody
    public String nickCheck(String checkNick) {
    	int result = memberService.nickCheck(checkNick);
    	
    	if(result > 0) {
    		return "N";
    	} else {
    		return "Y";
    	}
    }
    
    @PostMapping("updateMember")
    public String updateMember(Member m, HttpSession session) {
    	int result = memberService.updateMember(m);
    	
    	if(result > 0) {
    		session.setAttribute("loginMember", memberService.loginMember(m));
    		session.setAttribute("alertMsg", "정보 변경 완료");
    	} else {
    		session.setAttribute("alertMsg", "정보 변경 실패");
    	}
    	
    	return "redirect:/personal.me";
    }
    
    @PostMapping("updatePwd.me")
    public String updatePwd(Member m, String currPw, HttpSession session) {
    	m.setMemberId(((Member)session.getAttribute("loginMember")).getMemberId());
    	
    	if(!bcryptPasswordEncoder.matches(currPw, ((Member)session.getAttribute("loginMember")).getMemberPwd())) {
    		session.setAttribute("alertMsg", "비밀번호가 일치하지 않습니다.");
    		return "redirect:/";
    	} else {
        	m.setMemberPwd(bcryptPasswordEncoder.encode(m.getMemberPwd()));
        	
    		int result = memberService.updatePwd(m);
    		
    		if(result > 0) {
    			session.setAttribute("loginMember", memberService.loginMember(m));
    			session.setAttribute("alertMsg", "비밀번호 변경 완료");
        	} else {
        		session.setAttribute("alertMsg", "비밀번호 변경 실패");
        	}
    		
    		return "redirect:/personal.me";
    	}
    }
    
    @PostMapping("deleteMember.me")
    public String deleteMember(String memberPwd, HttpSession session) {
    	if(!bcryptPasswordEncoder.matches(memberPwd, ((Member)session.getAttribute("loginMember")).getMemberPwd())) {
    		session.setAttribute("alertMsg", "비밀번호가 다릅니다.");
    	} else {
    		int result = memberService.deleteMember(((Member)session.getAttribute("loginMember")).getMemberId());
    		
    		if(result > 0) {
    			session.removeAttribute("loginMember");
    			session.setAttribute("alertMsg", "회원탈퇴가 정상적으로 이루어졌습니다.");
    			return "redirect:/";
    		} else {
    			session.setAttribute("alertMsg", "회원탈퇴가 실패하였습니다.");
    		}
    	}
    	
		return "redirect:/personal.me";
    }
    
    // 아이디 찾기
    @RequestMapping("searchId.me")
    @ResponseBody
    public String searchId(String email) {
    	log.info(email);
    	String memberId = memberService.searchId(email);
    	log.info("memberId :" + memberId);
    	
    	return memberId;
    }
    
    // 비밀번호 찾기
    @RequestMapping("changePwdForm.me")
    public String searchPwd(Member m, Model model, HttpSession session) {    	
    	int result = memberService.searchPwd(m);
    	
    	System.out.println("result :" + result);
    	
    	if(result > 0) {
    		model.addAttribute("memberId", memberService.loginMember(m).getMemberId());
    		
    		return "member/changeMemberPwd";
    	} else {
    		session.setAttribute("alertMsg", "입력한 정보와 일치하는 비밀번호가 존재하지 않습니다.");
    		
    		return "redirect:/searchPwdForm.me";
    	}
    }
    
    // 비밀번호 수정(로그인 X)
    @PostMapping("changePwd.me")
    public String changePwd(Member m, @RequestParam(value="memberId") String memberId, HttpSession session) {
    	String encPwd = bcryptPasswordEncoder.encode(m.getMemberPwd());
    	m.setMemberPwd(encPwd);
    	m.setMemberId(memberId);
    	System.out.println("member :" + m);
    	System.out.println("memberId : " + memberId);
    	int result = memberService.changePwd(m);
    	
    	if(result > 0) {
    		session.setAttribute("alertMsg", "비밀번호 수정에 성공하셨습니다.");
    		
    		return "redirect:/loginForm.me";
    	} else {
    		session.setAttribute("alertMsg", "비밀번호 수정에 실패하였습니다.");
    		
    		return "redirect:/loginForm.me";
    	}
    }
    
    @ResponseBody
    @PostMapping("imgChangeAjax.me")
    public String imgChangeAjax(Member m, MultipartFile imgProfile, HttpSession session) {
    	m.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
    	m.setMemberId(((Member)session.getAttribute("loginMember")).getMemberId());
    	
    	if(!imgProfile.getOriginalFilename().equals("")) {
	    	m.setProfileImg("/resources/image/profileImg/"+ Template.saveFile(imgProfile, session, "/resources/image/profileImg/"));
	    	
	    	int result = memberService.imgChangeAjax(m);
	    	
	    	if(result > 0) {
	    		Member nm = memberService.loginMember(m);
	    		
	    		session.setAttribute("loginMember", nm);
	    		return nm.getProfileImg();
	    	} else {
	    		return "false";
	    	}
    	} else {
    		return "false";
    	}
    }
    
    @ResponseBody
    @PostMapping("resetImage.me")
    public String resetImage(Member m, HttpSession session) {
    	m.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
    	m.setMemberId(((Member)session.getAttribute("loginMember")).getMemberId());
    	
    	int result = memberService.imgChangeAjax(m);
    	
    	if(result > 0) {
    		Member nm = memberService.loginMember(m);
    		
    		session.setAttribute("loginMember", nm);
    		return nm.getProfileImg();
    	} else {
    		return "false";
    	}
    }
}
