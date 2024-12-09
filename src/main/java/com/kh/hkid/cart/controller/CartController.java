package com.kh.hkid.cart.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.hkid.cart.model.service.CartService;
import com.kh.hkid.cart.model.vo.Cart;
import com.kh.hkid.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CartController {
	
	private final CartService cartService;
	
	@Autowired
	public CartController(CartService cartService) {
		this.cartService = cartService;
	}
	
	@RequestMapping("cartlist.li")
	public String cartPage(int memberNo, Model model) {
		
		
		ArrayList<Cart> list = cartService.selectCart(memberNo);
		System.out.println(list);
		
		model.addAttribute("list", list);
		return "Products/carts";
	}
	
	@PostMapping("addCart.c")
	public int addCart(Cart c) {
		//ArrayList<Cart> list = 
		
		return cartService.addCart(c);
	}	
	
	
	@ResponseBody
	@GetMapping("/qchange")
	public int quantityChange(HttpSession session, int productNo, int productQuantity, Model model) {
		
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		
		log.info("memberNo"+memberNo);
		log.info("productNo" + productNo);
		log.info("productQuantity" + productQuantity);
		
		HashMap<Object, Integer> map = new HashMap<>();
		map.put("memberNo", memberNo);
		map.put("productNo", productNo);
		map.put("productQuantity",productQuantity);
						
		return cartService.changeQuantity(map);
	}
	
//	@PostMapping("delete.o")
//	public int delete(Cart c, Model model, int memberNo, int productNo) {
//				
//		
//		HashMap<Object, Integer> de = new HashMap<>();
//		de.put("memberNo", memberNo);
//		de.put("productNo", productNo);
//		
//		
//		return cartService.deleteCart(de);
//	}
	
	@ResponseBody
	@RequestMapping(value="delete.c", produces="application/json; charset-UTF-8")
	public int deleteOne(Cart c) {
		System.out.println(c);
		return cartService.deleteCart(c);		
	}
	
	

}
