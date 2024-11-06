package com.kh.hkid.diet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.hkid.diet.service.DietService;

@Controller
public class DietController {
	
	private final DietService dietService;
	
	public DietController(DietService dietService) {
		this.dietService = dietService;
	}
	
	@GetMapping("diet.ca")
	public String dietForm() {
		return "diet/dietForm";
	}
}
