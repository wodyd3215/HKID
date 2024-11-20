package com.kh.hkid.phase.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.phase.service.PhaseService;

@Controller
public class PhaseController {

	private final PhaseService phaseService;
	
	@Autowired
	public PhaseController(PhaseService phaseService) {
		this.phaseService = phaseService;
	}
	
//	@GetMapping("phase.li")
//	public String selectList(HttpSession session, Model model) {
//		
//		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
//		
//		model.addAttribute("phlist",phaseService.selectList(memberNo));
//		
//		return "Product/phaseList";
//	}
}
