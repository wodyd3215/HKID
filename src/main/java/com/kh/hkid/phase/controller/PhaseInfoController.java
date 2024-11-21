package com.kh.hkid.phase.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.phase.model.vo.Phase;
import com.kh.hkid.phase.service.PhaseService;

@Controller
public class PhaseInfoController {
	private final PhaseService phaseService;
	
	@Autowired
	public PhaseInfoController(PhaseService phaseService) {
		this.phaseService = phaseService;
	}
	
	@ResponseBody
	@RequestMapping("phaseInfo.li")
	public String selectPhaseInfo(HttpSession session, int productNo, Model model, Phase p) {
		
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
		if(memberNo == 0) {
			model.addAttribute("errorMsg","로그인 이후 이용 가능한 서비스입니다.");
		}
		
		// 유저 정보와 상품 정보 불러오기
//		model.addAttribute("m", phaseService.selectM(memberNo));
//		model.addAttribute("p", phaseService.selectP(productNo));
		
		// 
		
		HashMap<String, Object> order1= new HashMap<>();
		order1.put("memberNo", session.getAttribute("memberNo"));
		order1.put("productNo", session.getAttribute("productNo"));
		 
		ArrayList<Phase> order = phaseService.getProduct(order1);		 
		 
		model.addAttribute("order",order);		 
		
		return "order/orderInfo";
	}

	
	
	@GetMapping("phase.in")
	public String CompletePage(/*@RequestParam(value="") */HttpSession session, Phase p) {
		session.setAttribute("",p);
		return "order/orderComplete";
	}
}
