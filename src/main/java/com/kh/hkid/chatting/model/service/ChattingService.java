package com.kh.hkid.chatting.model.service;

import java.util.ArrayList;

import com.kh.hkid.chatting.model.dto.MessageLog;
import com.kh.hkid.chatting.model.vo.Message;

public interface ChattingService {
	// 채팅방 조회
	ArrayList<MessageLog> chatList(int senderNo);

	// 채팅 삭제
	void deleteChat(MessageLog ml);
	
	// 채팅 로그 조회
	ArrayList<MessageLog> selectChatLog(MessageLog ml);
	
	// 입력한 채팅 저장
	void inputChat(Message m);

}
