package com.kh.hkid.cart.controller;

import java.util.ArrayList;

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
		//ArrayList<Cart> = 
		
		return cartService.addCart(c);
	}	
	
	
	@ResponseBody
	@RequestMapping("/qchange")
	public int quantityChange(Cart c, int memberNo, String productNo, int productQuantity, Model model) {
		
		
		return cartService.changeQuantity(c);
	}
	
	
	@ResponseBody
	@PostMapping(value="delete.c", produces="application/json; chatset-UTF-8")
	public int deleteOne(@RequestParam(value="deCart")Cart c, HttpServletRequest request, HttpSession session) {
		
		int result = cartService.deleteCart(c);
		return result;
	}

}
