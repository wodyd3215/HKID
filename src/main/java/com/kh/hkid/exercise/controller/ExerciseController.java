package com.kh.hkid.exercise.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.exercise.model.vo.Exercise;
import com.kh.hkid.exercise.service.ExerciseService;

@Controller
public class ExerciseController {
	
	private final ExerciseService exerciseService;
	
	@Autowired
	public ExerciseController(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}
	
	@RequestMapping("list.ex")
	public String selectList(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int boardCount = exerciseService.selectListCount();
		
		PageInfo pi = Template.getPageInfo(boardCount, currentPage, 12, 15);
		
		ArrayList<Exercise> list = exerciseService.selectList(pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "exercise/mainExercise";
	}
	
	//필터검색
	@PostMapping("exercise.se")
	public String searchList(
			@RequestParam(value = "part", defaultValue="") List<String> selectedParts,
			@RequestParam(value = "difficulty", defaultValue="") List<String> selectDifficulties,
			@RequestParam(value = "keyword", defaultValue="") List<String> keyword,
			@RequestParam(value = "cpage", defaultValue="1") Integer currentPage, Model model) {
			int boardCount = exerciseService.selectListCount();
		
			// currentPage가 null일 경우 기본값 설정
		    if (currentPage == null) {
		        currentPage = 1;  // 기본값을 1로 설정
		    }
		    
			PageInfo pi = Template.getPageInfo(boardCount, currentPage, 12, 15);
			
		// HashMap에 필터 조건 추가
		HashMap<String, Object> filterMap = new HashMap<>();
		filterMap.put("parts", selectedParts);
		filterMap.put("difficulties", selectDifficulties);
		filterMap.put("keywords", keyword);
		
		
		
		List<Exercise> exercises = exerciseService.search(filterMap, pi);
		
		model.addAttribute("list", exercises);
		model.addAttribute("pi", pi);
		
		return "exercise/mainExercise";
		
	}
	
	@RequestMapping("exercise.de")
	public String exerciseDetail() {
		
		return "exercise/detailExercise";
	}
	
	
}
