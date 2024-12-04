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
import com.kh.hkid.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChattingController {

	private final ChattingService chattingService;
	
	@Autowired
	public ChattingController(ChattingService chattingService) {
		this.chattingService = chattingService;
	}
	
	// 채팅방 추가
	@RequestMapping(value="insertChat", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String insertChat(Chat c, HttpSession session) {
	    Member loginMember = (Member)session.getAttribute("loginMember");

	    c.setSenderNo(loginMember.getMemberNo());
	    
	    int result = chattingService.insertChat(c);
	    
	    if(result > 0) {
	    	// 추가한 채팅방 정보 조회
	    	ChatRoom cr = chattingService.selectChatInfo(c);
	    	return new Gson().toJson(cr);
	    } else {
	    	return null;
	    }
	}
	
	// 채팅방 조회
	@RequestMapping(value="chatList", produces = "application/json; charset = UTF-8")
	@ResponseBody
	public String chatList(int senderNo) {
		ArrayList<ChatRoom> cr = chattingService.chatList(senderNo);
		if(cr == null) {
			return null;
		} else {
			return new Gson().toJson(cr);
		}
	}
	
	// 채팅방 삭제
	@RequestMapping("deleteChat")
	@ResponseBody
	public void deleteChat(String chatId) {
		chattingService.deleteChat(chatId);
	}
	
	// 채팅방 로그 조회
	@RequestMapping(value="selectChatLog", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String selectChatLog(String chatId) {
		ArrayList<MessageLog> mlArr = chattingService.selectChatLog(chatId);
		
		if(mlArr == null) {
			return null;
		} else {
			return new Gson().toJson(mlArr);
		}
	}
}