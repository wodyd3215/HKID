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
			@RequestParam(value = "difficulty", defaultValue="") List<String> selectDifficulties, Exercise e, HttpSession session,  Model model) {
		
		// HashMap에 필터 조건 추가
		HashMap<String, Object> filterMap = new HashMap<>();
		filterMap.put("parts", selectedParts);
		filterMap.put("difficulties", selectDifficulties);
		
		
		List<Exercise> exercises = exerciseService.search(filterMap);
		
		model.addAttribute("list", exercises);
		
		return "exercise/mainExercise";
		
	}
	
	
}
