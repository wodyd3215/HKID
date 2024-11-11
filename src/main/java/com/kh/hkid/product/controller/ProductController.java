package com.kh.hkid.product.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.product.model.vo.Product;
import com.kh.hkid.product.model.vo.Review;
import com.kh.hkid.product.service.ProductService;

@Controller
public class ProductController {
	
	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
		
	@RequestMapping("product.li") // 상품페이지 메인
	public String selectProList(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int productCount = productService.selectListTotal();
		
		PageInfo pi = Template.getPageInfo(productCount, currentPage, 9, 5);
		ArrayList<Product> list = productService.selectList(pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "product/productList";
	}
	
	@GetMapping("deproduct.li")
	public String selectItem() {
		
		return "product/productDetailview";	
	}
	
	
	@GetMapping("/products/productPage")
	public String showProductPage() {
		return "Products/productPageDetail";
	}
	
	@ResponseBody
	@RequestMapping("pselectSide.li")
	public List<Product> ajaxSelect(Product p) {
		return productService.selectSideItem(p);
	}
}
