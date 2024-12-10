package com.kh.hkid.product.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.Community;
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
		
		PageInfo pi = Template.getPageInfo(productCount, currentPage, 5, 9);
		ArrayList<Product> list = productService.selectList(pi);

		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "Products/productPage";
	}
	
	// 카테고리에 맞는 상품 목록을 반환하는 API
    @GetMapping("product.se")
    public String selectProductCategoryList(@RequestParam(value="cpage", defaultValue="1") int currentPage, 
    										Model model, String category) {
    	int productCount = productService.selectProductCategoryListCount(category);
    	
    	PageInfo pi = Template.getPageInfo(productCount, currentPage, 5, 9);
    	ArrayList<Product> list = productService.selectProductCategoryList(pi, category);	//게시글 리스트
    	
    	model.addAttribute("list", list);
		model.addAttribute("category", category);
		model.addAttribute("pi", pi);
		
        return "Products/productPage";
    }
    
	
	@GetMapping("deteilItem.li")
	public String selectItem(int pno, Model model) {
		Product p = productService.selectProduct(pno);
		model.addAttribute("p", p);
		return "Products/productPageDetail";	
	}
	
	@ResponseBody
	@RequestMapping(value="/chooseNav", produces="application/json; charset=UTF-8")
	public String ajaxSelectedNav(@RequestParam("sideNav")String selectedValue) {
		
		ArrayList<Product> chooseNav = productService.ajaxSelectedNav(selectedValue);		
		
		return new Gson().toJson(chooseNav);
	}
	
	@ResponseBody
	@RequestMapping(value="/Btn", produces="application/json; charset=UTF-8")
	public String ajaxTabBtn(@RequestParam("ItemRbtn")String Rbtn) {
		
		ArrayList<Product> selectedRbtn = productService.ajaxTabBtn(Rbtn);		
		
		return new Gson().toJson(selectedRbtn);
	}
	
	// 게시글 검색 [작성자, 제목, 내용]
	@GetMapping("productSearch.se")
	public String searchItemKey(@RequestParam(value="pPage", defaultValue="1") int pPage,
			@RequestParam(value="searchCategory", defaultValue="전체")String category,
			String keyword,
			String condition,
			Model model) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("keyword", keyword);
		map.put("condition", condition);
		map.put("category", category);
		
		//선택한 카테고리의 게시글 개수
		int searchCount = productService.selectSearchCount(map); //검색한 게시글의 개수(카테고리, 검색조건)
		System.out.println("게시글의 개수: "+searchCount);
		PageInfo pi = Template.getPageInfo(searchCount, pPage, 5, 9);
		ArrayList<Product> list = productService.selectSearchList(map, pi);
		
		System.out.println("게시글 목록: "+list);
		
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		model.addAttribute("category", category);
		model.addAttribute("keyword", keyword);
		return "Products/productPage";
	}
	
//	@GetMapping("/products/productPage")
//	public String showProductPage() {
//		return "Products/productPageDetail";
//	}
	
}
