package com.kh.hkid.chatting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChattingController {

	@Autowired
	public ChattingController() {
		
	}
	
	@GetMapping("chatting.ch")
	public String chattingBox() {
		return "common/chatBox";
	}
}
