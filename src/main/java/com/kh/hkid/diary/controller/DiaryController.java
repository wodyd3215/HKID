package com.kh.hkid.diary.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.diary.model.vo.Diary;
import com.kh.hkid.diary.service.DiaryService;
import com.kh.hkid.member.model.vo.Member;

@Controller
public class DiaryController {
	
	private final DiaryService diaryService;
	
	@Autowired
	public DiaryController(DiaryService diaryService) {
		this.diaryService = diaryService;
	}
	
	@GetMapping("myDiaryList.me")
	public String myDiaryList(HttpSession session, Model model) {
    	int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
    	model.addAttribute("pageName", "myDiaryList");
    	model.addAttribute("optional", memberNo);
		
		return "member/myDiaryPage";
	}
	
	// 내 다이어리 리스트 목록
	@ResponseBody
	@RequestMapping(value="selectDiaryList.me", produces="application/json; charset=UTF-8")
    public String selectMyDiaryList(int memberNo, int currentPage, int diaryLimit) {
		int diaryCount = diaryService.selectDiaryCount(memberNo);

		PageInfo pi = Template.getPageInfo(diaryCount, currentPage, 1, diaryLimit);
		
		ArrayList<Diary> dList = diaryService.selectMyDiaryList(pi, memberNo);
		
		return new Gson().toJson(dList);
    }
    
    @GetMapping("myDiary.me")
    public String myDiary() {
    	return "member/myDiaryDetail";
    }
    
    @GetMapping("diaryEnroll.me")
    public String diaryEnroll() {
    	return "member/myDiaryEnroll";
    }
}
