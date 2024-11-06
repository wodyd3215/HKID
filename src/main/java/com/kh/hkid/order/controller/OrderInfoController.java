package com.kh.hkid.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OrderInfoController {
	
	@RequestMapping("order.in")
	public String orderInfo() {
		
		return "order/orderInfo";
	}
	
	
	@RequestMapping("order.cp")
	public String orderComplete() {
		
		return "order/orderComplete";
	}

}
