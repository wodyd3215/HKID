package com.kh.hkid.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@GetMapping("/products/productPage")
	public String showProductPage() {
		return "Products/productPage";
	}
	
}
