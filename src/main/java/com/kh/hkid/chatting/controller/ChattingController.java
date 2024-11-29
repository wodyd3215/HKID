package com.kh.hkid.chatting.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.kh.hkid.chatting.model.dto.ChatRoom;
import com.kh.hkid.chatting.model.dto.MessageLog;
import com.kh.hkid.chatting.model.service.ChattingService;
import com.kh.hkid.chatting.model.vo.Chat;
import com.kh.hkid.chatting.model.vo.Message;
import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.member.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChattingController {

	private final ChattingService chattingService;
	private final MemberService memberService;
	
	@Autowired
	public ChattingController(ChattingService chattingService, MemberService memberService) {
		this.chattingService = chattingService;
		this.memberService = memberService;
		
	}
	
	// 채팅방 조회
	@RequestMapping(value="chatList", produces = "application/json; charset = UTF-8")
	@ResponseBody
	public String chatList(int senderNo) {
		ArrayList<MessageLog> ml = chattingService.chatList(senderNo);
		if(ml == null) {
			return null;
		} else {
			return new Gson().toJson(ml);
		}
	}
	
	// 채팅 삭제
	@RequestMapping("deleteChat")
	@ResponseBody
	public void deleteChat(MessageLog ml) {
		chattingService.deleteChat(ml);
	}
	
	// 채팅 로그 조회
	@RequestMapping(value="selectChatLog", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectChatLog(MessageLog ml) {
		ArrayList<MessageLog> mlArr = chattingService.selectChatLog(ml);
		
		if(mlArr == null) {
			return null;
		} else {
			return new Gson().toJson(mlArr);
		}
	}
	
	// 입력한 채팅 저장
	@RequestMapping("inputChat")
	@ResponseBody
	public void inputChat(Message m) {
		System.out.println("입력한 채팅 도착" + m);
		chattingService.inputChat(m);
	}
}