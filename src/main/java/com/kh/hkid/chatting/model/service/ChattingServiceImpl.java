package com.kh.hkid.chatting.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.chatting.model.dao.ChattingDao;
import com.kh.hkid.chatting.model.dto.MessageLog;
import com.kh.hkid.chatting.model.vo.Message;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChattingServiceImpl implements ChattingService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ChattingDao chattingDao;
	
	// 채팅방 조회
	@Override
	public ArrayList<MessageLog> chatList(int senderNo) {
		return chattingDao.chatList(sqlSession, senderNo);
	}

	// 채팅 삭제
	@Override
	public void deleteChat(MessageLog ml) {
		chattingDao.deleteChat(sqlSession, ml);
	}

	// 채팅 로그 조회
	@Override
	public ArrayList<MessageLog> selectChatLog(MessageLog ml) {
		return chattingDao.selectChatLog(sqlSession, ml);
	}

	// 입력한 채팅 저장
	@Override
	public void inputChat(Message m) {
		chattingDao.inputChat(sqlSession, m);
	}

}
