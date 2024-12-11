package com.kh.hkid.favorite.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.favorite.model.vo.Favorite;
import com.kh.hkid.favorite.service.FavoriteService;
import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.phase.model.vo.Phase;

@Controller
public class FavoriteController {
	private final FavoriteService favoriteService;
	
	@Autowired
	public FavoriteController(FavoriteService favoriteService) {
		this.favoriteService = favoriteService;
	}
	
	@GetMapping("favorite.li")
	public String selectList(@RequestParam(value="cpage", defaultValue="1")int currentPage, Model model, int memberNo) {
		int fCount = favoriteService.selectListCount(memberNo);	
		
		PageInfo pi = Template.getPageInfo(fCount, currentPage, 10, 10);		
		ArrayList<Favorite> flist = favoriteService.selectList(memberNo, pi);
		
		model.addAttribute("flist", flist);
		model.addAttribute("pi", pi);
		
		System.out.println("flist: " + flist);
		System.out.println("Member No: " + memberNo);
		
		return "Products/favoriteList";
	}
	

}
