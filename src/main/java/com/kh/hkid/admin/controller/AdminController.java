package com.kh.hkid.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.hkid.admin.service.AdminService;

@Controller
public class AdminController {
	private final AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("pManagement.ad")
	public String adminP() {
		return "admin/pManagement";
	}
	
	@GetMapping("bManagement.ad")
	public String adminB() {
		return "admin/bManagement";
	}
}
