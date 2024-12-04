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
		System.out.println("채팅방 조회 시작 : " + senderNo);
		ArrayList<MessageLog> ml = chattingService.chatList(senderNo);
		System.out.println("채팅방 조회 끝 : " + ml);
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
		System.out.println("채팅 로그 조회 시작 : " + ml);
		ArrayList<MessageLog> mlArr = chattingService.selectChatLog(ml);
		System.out.println("채팅 로그 조회 끝 : " + mlArr);
		
		return new Gson().toJson(mlArr);
		
	}
	
	// 입력한 채팅 저장
	@RequestMapping(value="inputChat", produces="application/json; charset=UTF-8")
	@ResponseBody
	public String inputChat(Message m, int memberNo) {
		System.out.println("입력한 채팅 도착" + m);
		System.out.println("입력한 채팅 도착(memberNo) : " + memberNo);
		
		if(m.getSenderNo() == memberNo) {
			m.setSenderNo(memberNo);
			chattingService.inputChat(m);
		} else {
			int n = m.getSenderNo();
			m.setSenderNo(memberNo);
			m.setReceiverNo(n);
			chattingService.inputChat(m);
		}
		

		Member mem = memberService.senderInfo(m);
		
		System.out.println("채팅 입력 정보 : " + mem);
		
		return new Gson().toJson(mem);
	}
}