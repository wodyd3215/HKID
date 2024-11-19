package com.kh.hkid.favorite.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.hkid.favorite.model.vo.Favorite;
import com.kh.hkid.favorite.service.FavoriteService;

@Controller
public class FavoriteController {
	private final FavoriteService favoriteService;
	
	@Autowired
	public FavoriteController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	
	@GetMapping("favorite.li")
	public String selectList(int memberNo, Model model) {
		ArrayList<Favorite> flist = favoriteService.selectList(memberNo);
		
		model.addAttribute("list",flist);
		
		return "Products/favoriteList";
	}
	

}
