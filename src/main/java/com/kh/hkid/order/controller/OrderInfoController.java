package com.kh.hkid.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.hkid.order.model.vo.Order;
import com.kh.hkid.order.service.OrderService;

@Controller
public class OrderInfoController {
	
	private final OrderService orderService;	
	
	@Autowired
	public OrderInfoController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@RequestMapping("order.in")
	public String orderInfo() {
		
		return "order/orderInfo";
	}
	
	
	@RequestMapping("order.cp")
	public String orderComplete(Order o, Model model) {
		System.out.println("구매 정보 : " + o);
		
		Order order = orderService.insertPurchaseInfo(o);
		System.out.println("저장된 구매 정보 : " + order);
		model.addAttribute("order", order);
		
		return "order/orderComplete";
	}

}
