package com.kh.hkid.challenge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.challenge.model.vo.ChallengeBoard;
import com.kh.hkid.challenge.service.ChallengeService;
import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;

@Controller
public class ChallengeController {
	private final ChallengeService challengeService;
	
	@Autowired
	public ChallengeController(ChallengeService challengeService) {
		this.challengeService = challengeService;
		
	}
	
	@RequestMapping("ch.m")
	public String challenge(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int boardCount = challengeService.boardCount();
		
		PageInfo pi = Template.getPageInfo(boardCount, currentPage, 5, 6);
		
		ArrayList<Challenge> list = challengeService.selectList(pi);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "challenge/challengeM";
	}
	
	@RequestMapping("ch.b")
	public String challengeBoard(@RequestParam(value="cpage", defaultValue="1") Integer currentPage, int cno, Model model) {
		int challengeBoardCount = challengeService.challengeBoardCount(cno);
		
		Challenge c = challengeService.selectName(cno);
		
		PageInfo pi = Template.getPageInfo(challengeBoardCount, currentPage, 5, 10);
		
		ArrayList<ChallengeBoard> list = challengeService.chBoardselectList(cno, pi);

		System.out.println("list" + list);
		System.out.println("pi" + pi);
		System.out.println("c" + c);
		model.addAttribute("c", c);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "challenge/challengeD";
	}

}
