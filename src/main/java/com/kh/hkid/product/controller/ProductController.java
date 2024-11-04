package com.kh.hkid.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	@GetMapping("/products/productPage")
	public String showProductPage() {
		return "Products/productPage";
	}
}
