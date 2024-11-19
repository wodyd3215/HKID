package com.kh.hkid.favorite.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.hkid.favorite.model.vo.Favorite;
import com.kh.hkid.favorite.service.FavoriteService;
import com.kh.hkid.member.model.vo.Member;

@Controller
public class FavoriteController {
	private final FavoriteService favoriteService;
	
	@Autowired
	public FavoriteController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	
	@GetMapping("favorite.li")
	public String selectList(Model model, HttpSession session) {
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		ArrayList<Favorite> flist = favoriteService.selectList(memberNo);
		
		model.addAttribute("list",flist);
		
		return "Products/favoriteList";
	}
	

}
