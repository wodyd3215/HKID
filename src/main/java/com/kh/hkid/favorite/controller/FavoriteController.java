package com.kh.hkid.favorite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.kh.hkid.favorite.model.vo.Favorite;
import com.kh.hkid.favorite.service.FavoriteService;

@Controller
public class FavoriteController {
	private final FavoriteService favoriteService;
	
	@Autowired
	public FavoriteController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	
	
	public String selectList(Model model) {
		ArrayList<Favorite> list = favoriteService.selectList();
		
		model.addAttribute("list",list);
		
		return "Products/favoriteList";
	}
	
}
