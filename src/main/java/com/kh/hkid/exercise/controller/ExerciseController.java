package com.kh.hkid.exercise.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		PageInfo pi = Template.getPageInfo(boardCount, currentPage, 5, 15);
		
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
			@RequestParam(value = "cpage", defaultValue="1") Integer currentPage, Model model, HttpSession session) {
			int boardCount = exerciseService.selectListCount();
		
			// currentPage가 null일 경우 기본값 설정
		    if (currentPage == null) {
		        currentPage = 1;  // 기본값을 1로 설정
		    }
		    
			PageInfo pi = Template.getPageInfo(boardCount, currentPage, 5, 15);
			
			
		// HashMap에 필터 조건 추가
		HashMap<String, Object> filterMap = new HashMap<>();
		filterMap.put("parts", selectedParts);
		filterMap.put("difficulties", selectDifficulties);
		filterMap.put("keywords", keyword);
		
		// 검색 조건을 세션에 저장
        session.setAttribute("filterMap", filterMap);
		
		
		List<Exercise> exercises = exerciseService.search(filterMap, pi);
		
		model.addAttribute("filterMap", filterMap);
		model.addAttribute("list", exercises);
		model.addAttribute("pi", pi);
		
		
		return "exercise/mainExercise";
		
	}
	
	@GetMapping("exercise.de")
	public String selectExercise(int eno, Model model) {
		
		 // 운동 정보 가져오기
		Exercise e = exerciseService.selectExercise(eno);
		
		// 운동 설명을 문장 단위로 분할하여 리스트로 변환
		List<String> descriptionList = Arrays.asList(e.getExerciserDescription().split("\\.\\s*"));
		
		model.addAttribute("e", e);
		model.addAttribute("descriptionList", descriptionList);
		
		return "exercise/detailExercise";
	}
	
	
}
