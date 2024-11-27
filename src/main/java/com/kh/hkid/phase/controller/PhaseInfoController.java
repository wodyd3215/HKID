package com.kh.hkid.phase.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.phase.model.vo.Phase;
import com.kh.hkid.phase.service.PhaseService;
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
	
	@ResponseBody
	@RequestMapping("phaseInfo.li")
	public String selectPhaseInfo(HttpSession session, Model model, Phase p) {
		
		Member m = (Member)session.getAttribute("loginMember");		
		if(m == null) {
			session.setAttribute("alertMsg","로그인 이후 이용 가능한 서비스입니다.");
		}		
		
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
	
	@GetMapping("review/{memberNo}")
	public String reviewScreen(@RequestParam(value="memberNo") int memberNo,
								@RequestParam(value="productNo")int productNo,
								Model model) {
		//Member m = ;
		Review r = phaseService.writeReview(productNo) ;
		model.addAttribute("memberNo", memberNo);
		model.addAttribute("productNo", productNo);
		return "Product/reviewScreen";
	}
	
	
}
