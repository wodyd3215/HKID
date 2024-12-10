package com.kh.hkid.diary.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.diary.model.vo.Diary;
import com.kh.hkid.diary.service.DiaryService;
import com.kh.hkid.diet.model.vo.Diet;
import com.kh.hkid.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		
		return "diary/myDiaryPage";
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
        
    @GetMapping("diaryEnroll.me")
    public String diaryEnroll() {
    	return "diary/myDiaryEnroll";
    }
        
    // 일기 등록
    @PostMapping("insertDiary.di")
    public String insertDiary(Diary d, HttpSession session) {
    	d.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
    	if(diaryService.insertDiary(d) > 0) {
    		session.setAttribute("alertMsg", "일기 작성 성공");
    	} else {
    		session.setAttribute("alertMsg", "일기 작성 실패");	
    	}
    	
    	return "redirect:/myDiaryList.me";
    }
    
    @GetMapping("detailDiary.di")
    public String detailDiary(Diary dy, Model model, HttpSession session) {
    	dy.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
    	
    	Diary ndy = diaryService.detailDiary(dy);
    	
    	log.info("다이어트 정보 있음: " + ndy.getFoodNo());
    	if(ndy.getFoodNo() != 0) {
    		Diet dt = diaryService.selectMyDiet(ndy.getFoodNo());
    		
        	model.addAttribute("diet", dt);
    	}

    	model.addAttribute("diary", ndy);
  	
    	return "diary/myDiaryDetail";
    }
    
    @PostMapping("delete.di")
    public String deleteDiary(Diary d, Model model, HttpSession session) {
    	d.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
    	
    	if(diaryService.deleteDiary(d) > 0) {
    		session.setAttribute("alertMsg", "일기 삭제 완료");
    		return "redirect:/myDiaryList.me";
    	} else {
    		session.setAttribute("alertMsg", "일기 삭제 실패");
    		return "redirect:/detailDiary.di?diaryNo=" + d.getDiaryNo();
    	}
    	
    }
    
    @PostMapping("updateDiaryForm.di")
    public String updateDiaryForm(Diary d, Model model, HttpSession session) {
    	d.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
    	
    	model.addAttribute("diary", diaryService.detailDiary(d));
    	
    	return "diary/myDiaryUpdate";
    }
    
    @PostMapping("updateDiary.di")
    public String updateDiary(Diary d, Model model, HttpSession session) {
    	
    	d.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
    	
    	if(diaryService.updateDiary(d) > 0) {
    		session.setAttribute("alertMsg", "다이어리 수정 성공");
    	} else { 
    		session.setAttribute("alertMsg", "다이어리 수정 실패");
    	}
    	
    	return "redirect:/detailDiary.di?diaryNo=" + d.getDiaryNo();
    }
}
