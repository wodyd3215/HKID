package com.kh.hkid.challenge.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	public String challengeBoard(
			@RequestParam(value="cpage", defaultValue="1") Integer currentPage,
			@RequestParam(value="choiceBoardCount", defaultValue="10") int choiceBoardCount, //글 개수
			@RequestParam(value = "cno") int cno,
			Model model) {
		int challengeBoardCount = challengeService.challengeBoardCount(cno);
		
		Challenge c = challengeService.selectName(cno);
		
		PageInfo pi = Template.getPageInfo(challengeBoardCount, currentPage, 10, choiceBoardCount);
		
		ArrayList<ChallengeBoard> list = challengeService.chBoardselectList(cno, pi);

		System.out.println("list" + list);
		System.out.println("pi" + pi);
		System.out.println("c" + c);
		model.addAttribute("cno", cno);
		model.addAttribute("c", c);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "challenge/challengeD";
	}
	
	@GetMapping("searchBoard.ch")
	public String SearchChallengeBoard(
			@RequestParam(value="cpage", defaultValue="1") Integer currentPage, //현재 페이지
			@RequestParam(value="choiceBoardCount", defaultValue="10") int choiceBoardCount, //글 개수
			@RequestParam(value = "cno") int cno,
			String keyword, String condition, Model model) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		
		HashMap<String, Object> param = new HashMap<>();
		param.put("cno", cno);
	    param.putAll(map); // 기존 map 데이터를 추가
	    
		int searchCount = challengeService.selectSearchCount(param);	//검색한 게시글의 개수
		
		PageInfo pi = Template.getPageInfo(searchCount, currentPage, 10, choiceBoardCount);
		
		ArrayList<ChallengeBoard> list = challengeService.chBoardselectList(param, pi);
		System.out.println("searchCount" + searchCount);
		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		return "challenge/challengeD";
	}
	
	

}
