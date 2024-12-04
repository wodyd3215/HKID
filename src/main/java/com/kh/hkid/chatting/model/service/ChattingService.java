package com.kh.hkid.chatting.model.service;

import java.util.ArrayList;

import com.kh.hkid.chatting.model.dto.ChatRoom;
import com.kh.hkid.chatting.model.dto.MessageLog;
import com.kh.hkid.chatting.model.vo.Chat;

public interface ChattingService {
	// 채팅방 추가
	int insertChat(Chat c);
	
	// 추가한 채팅방정보 조회
	ChatRoom selectChatInfo(Chat c);
	
	// 채팅방 조회
	ArrayList<ChatRoom> chatList(int senderNo);
	
	// 채팅방 삭제
	void deleteChat(String chatId);
	
	// 채팅방 로그 조회
	ArrayList<MessageLog> selectChatLog(String chatId);
}
