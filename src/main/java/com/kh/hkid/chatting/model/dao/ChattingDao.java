package com.kh.hkid.chatting.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.chatting.model.dto.ChatRoom;
import com.kh.hkid.chatting.model.dto.MessageLog;
import com.kh.hkid.chatting.model.vo.Chat;

@Repository
public class ChattingDao {
	// 채팅방 추가
	public int insertChat(SqlSessionTemplate sqlSession, Chat c) {
		return sqlSession.insert("chatMapper.insertChat", c);
	}
	
	// 추가한 채팅방정보 조회
	public ChatRoom selectChatInfo(SqlSessionTemplate sqlSession, Chat c) {
		
		return sqlSession.selectOne("chatMapper.selectChatInfo", c);
	}
	
	// 채팅방 조회
	public ArrayList<ChatRoom> chatList(SqlSessionTemplate sqlSession, int senderNo) {
		return (ArrayList)sqlSession.selectList("chatMapper.chatList", senderNo);
	}
	
	// 채팅방 삭제
	public void deleteChat(SqlSessionTemplate sqlSession, String chatId) {
		sqlSession.delete("chatMapper.deleteChat", chatId);
	}
	
	// 채팅방 로그 조회
	public ArrayList<MessageLog> selectChatLog(SqlSessionTemplate sqlSession, String chatId) {
		return (ArrayList)sqlSession.selectList("chatMapper.selectChatLog", chatId);
	}
}
