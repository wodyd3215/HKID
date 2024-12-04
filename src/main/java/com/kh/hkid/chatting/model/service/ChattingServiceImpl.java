package com.kh.hkid.chatting.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.hkid.chatting.model.dao.ChattingDao;
import com.kh.hkid.chatting.model.dto.ChatRoom;
import com.kh.hkid.chatting.model.dto.MessageLog;
import com.kh.hkid.chatting.model.vo.Chat;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChattingServiceImpl implements ChattingService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ChattingDao chattingDao;

	// 채팅방 추가
	@Transactional
	@Override
	public int insertChat(Chat c) {
		return chattingDao.insertChat(sqlSession, c);
	}

	// 추가한 채팅방 정보 조회
	@Override
	public ChatRoom selectChatInfo(Chat c) {
		return chattingDao.selectChatInfo(sqlSession, c);
	}
	
	// 채팅방 조회
	@Override
	public ArrayList<ChatRoom> chatList(int senderNo) {
		return chattingDao.chatList(sqlSession, senderNo);
	}

	// 채팅방 삭제
	@Override
	public void deleteChat(String chatId) {
		chattingDao.deleteChat(sqlSession, chatId);
	}

	// 채팅방 로그 조회
	@Override
	public ArrayList<MessageLog> selectChatLog(String chatId) {
		return chattingDao.selectChatLog(sqlSession, chatId);
	}
}
