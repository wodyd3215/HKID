package com.kh.hkid.phase.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.phase.model.vo.Phase;
import com.kh.hkid.phase.service.PhaseService;
import com.kh.hkid.product.model.vo.Product;
import com.kh.hkid.product.model.vo.Review;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PhaseInfoController {
	private final PhaseService phaseService;	
	
	@Autowired
	public PhaseInfoController(PhaseService phaseService) {
		this.phaseService = phaseService;
	}
	
	// 결제 화면 이동
	@ResponseBody
	@RequestMapping("phaseInfo.li")
	public String selectPhaseInfo(@RequestParam(value="phaseList") String phaseList,
								HttpSession session, Model model, Phase p) {
		
		
//		Member m = (Member)session.getAttribute("loginMember");		
//		if(m == null) {
//			session.setAttribute("alertMsg","로그인 이후 이용 가능한 서비스입니다.");
//			return "redirect:/loginForm.me";
//		}
		
		
//		HashMap<String, Object> order1= new HashMap<>();
//		order1.put("memberNo", (m));
//		order1.put("productNo", session.getAttribute("productNo"));
//		 
//		ArrayList<Phase> order = phaseService.selectList(order1);		 
//		 
//		model.addAttribute("order",order);
		
		return "order/orderInfo";
	}

	
	
//	@GetMapping("phase.in")
//	public String CompletePage(Phase p,HttpSession session, Model model, ModelAndView mv) {
//		int result = phaseService.insertPhase(p);
//		
//		if(result > 0) {
//			model.getAttribute("p", phaseService.selectList(p));
//		} else {
//			
//		}
//		session.setAttribute("",p);
//		return "order/orderComplete";
//	}
	
	// 리뷰 등록
	@ResponseBody
	@PostMapping(value="", produces = "application/json; charset=UTF-8")
	public String reviewScreen(int rvno, Review r, Product p,Model model, HttpSession session, HttpServletRequest request) {
		int code = 0;
		String resultCode;
		String msg;		
		
		Member m = (Member)session.getAttribute("loginMember");
		
		if(m == null) {
			session.setAttribute("alertMsg","로그인 이후 이용 가능한 서비스입니다.");
			return "redirect:/loginForm.me";
		}
		r.setMemberNo(m.getMemberNo());
		// 시퀸스가 아닌 UUID 를 사용하여 시퀸스에 의존하지 않음
		r.setReviewNo(UUID.randomUUID().hashCode()); 
				
		model.addAttribute("productNo", p);
		
		try {
			int result = phaseService.addReview(r);
			if (result > 0) {
				code = 1;
				resultCode = "success";
				msg = "리뷰가 성공적으로 등록되었습니다.";
			} else {
				code = -1;
				resultCode = "fail";
				msg = "리뷰 등록 중 오류가 발생했습니다.";
			}
			
		}catch(Exception e) {
			 code = -1;
	        resultCode = "fail";
	        msg = "예기치 못한 오류가 발생했습니다.";
		}		
		
		return "Product/reviewScreen";
	}
	
	
}
