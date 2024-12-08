package com.kh.hkid.cart.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.hkid.cart.model.service.CartService;
import com.kh.hkid.cart.model.vo.Cart;

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
	@RequestMapping("/qchange")
	public int quantityChange(int memberNo, int productNo, int productQuantity, Model model) {
		HashMap<Object, Integer> map = new HashMap<>();
		map.put("memberNo", memberNo);
		map.put("productNo", productNo);
		map.put("productQuantity",productQuantity);
						
		return cartService.changeQuantity(map);
	}
	
	@PostMapping("delete.o")
	public String delete(Cart c, Model model, int memberNo, int productNo) {
				
		
		HashMap<Object, Integer> de = new HashMap<>();
		de.put("memberNo", memberNo);
		de.put("productNo", productNo);
		
		
		return cartService.deleteCart(de);
	}
	
	@ResponseBody
	@PostMapping("delete.c")
	public int deleteOne(int memberNo, int productNo, Cart c, Model model, HttpServletRequest request) {
		
		String[] pick = request.getParameterValues("valueArr");
		
		
		
		int result = cartService.deleteCart(c);
		return result;
	}

}
