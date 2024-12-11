package com.kh.hkid.cart.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	
	@ResponseBody
	@RequestMapping(value="delete.c", produces="application/json; charset-UTF-8")
	public int deleteOne(Cart c) {
		System.out.println(c);
		return cartService.deleteCart(c);		
	}
	
	@ResponseBody
	@RequestMapping(value="delete.a", produces="application/json; charset-UTF-8")
	public int deleteAll(@RequestParam(value="productNo[]") ArrayList<String> pno, Cart c, HttpSession session) {
		
		Member m = (Member)session.getAttribute("loginMember");
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("memberNo", m.getMemberNo());
		map.put("productNo", pno);
		
		System.out.println();
		return cartService.deleteCarts(map);
	}

}
