package com.kh.hkid.admin.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.hkid.admin.service.AdminService;
import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.Community;

@Controller
public class AdminController {
	private final AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("product.ad")
	public String product() {
		return "admin/productManagement";
	}
	
	@GetMapping("reportedBoard.ad")
	public String reportedBoard() {
		return "admin/reportedBoard";
	}
	
	@GetMapping("reportedUser.ad")
	public String reportedUser() {
		return "admin/reportedUser";
	}
	
	@GetMapping("accRecovery.ad")
	public String accRecovery() {
		return "admin/accRecovery";
	}
	
	@GetMapping("reportedReply.ad")
	public String reportedReply() {
		return "admin/reportedReply";
	}
	
	@GetMapping("notice.ad")
	public String notice(@RequestParam(value="cpage", defaultValue="1") int currentPage, 
			   			 @RequestParam(value="categoty", defaultValue="co") String category, Model model) {
		int totalCount;
		ArrayList<Community> list = null;
		PageInfo pi = null;
		
		if(category.equals("co")) {
			totalCount = adminService.noticeCount();
			
			pi = Template.getPageInfo(totalCount, currentPage, 10, 10);
			list = adminService.selectNotice(pi);
		}
		
		System.out.println(list);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return "admin/noticeManagement";
	}
	
	//상품 등록
	@GetMapping("pEnroll.ad")
	public String productEnroll() {
		return "admin/productEnroll";
	}
	
	@GetMapping("nEnroll.ad")
	public String noticeEnroll() {
		
		
		return "admin/noticeEnroll";
	}
}
