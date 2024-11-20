package com.kh.hkid.diet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.hkid.diet.model.vo.Diet;
import com.kh.hkid.diet.service.DietService;
import com.kh.hkid.member.model.vo.Member;

@Controller
public class DietController {
	
	private final DietService dietService;
	
	@Autowired
	public DietController(DietService dietService) {
		this.dietService = dietService;
	}
	
	@GetMapping("diet.ca")
	public String dietForm(Model model) {
		return "diet/dietForm";
	}
	
	// 영양정보 계산 결과 저장
	@RequestMapping("saveDietInfo.ca")
	public String saveDietInfo(Diet d, HttpSession session) {
		System.out.println("dietController 도착!!");
		d.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
		
		int result = dietService.saveDietInfo(d);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "영양 정보 저장에 성공하였습니다.");
			
			return "redirect:/diet.ca";
		} else {
			session.setAttribute("alertMsg", "영양 정보 저장에 실패하였습니다.");
			
			return "redirect:/diet.ca";
		}
	}
	
	@ResponseBody
	@PostMapping(value="loadDietAjax", produces="application/json; charset=UTF-8")
	public String loadDietAjax(HttpSession session) {
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		return new Gson().toJson(dietService.loadDietAjax(memberNo)); 
	}
}
