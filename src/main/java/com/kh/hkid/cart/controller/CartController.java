package com.kh.hkid.cart.controller;

import java.util.ArrayList;

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
	
	@ResponseBody
	@RequestMapping(value="addCart.c", produces="application/json; chatset-UTF-8")
	public int addCart(Cart c) {
		
		return cartService.addCart(c)/* > 0 ? "success" : "fail"*/;
	}
	
	@RequestMapping("cartlist.li")
	public String cartPage(int memberNo, Model model) {
		
		
		ArrayList<Cart> list = cartService.selectCart(memberNo);
		
		
		model.addAttribute("list", list);
		return "Products/carts";
	}
	
	@ResponseBody
	@RequestMapping("/qchange")
	public int quantityChange(Cart c) {		
		return cartService.changeQuantity(c);
	}
	
	
	@ResponseBody
	@RequestMapping("/deleteOne")
	public int deleteOne(Cart c) {
		int result = cartService.deleteOne(c);
		
		return result;
	}

}
