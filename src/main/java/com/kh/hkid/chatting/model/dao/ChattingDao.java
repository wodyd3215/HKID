package com.kh.hkid.chatting.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.chatting.model.dto.ChatRoom;
import com.kh.hkid.chatting.model.dto.MessageLog;
import com.kh.hkid.chatting.model.vo.Chat;
import com.kh.hkid.chatting.model.vo.Message;
import com.kh.hkid.member.model.vo.Member;

@Repository
public class ChattingDao {
	// 채팅방 조회
	public ArrayList<MessageLog> chatList(SqlSessionTemplate sqlSession, int senderNo) {
		return (ArrayList)sqlSession.selectList("chatMapper.chatList", senderNo);
	}
	
	// 채팅 삭제
	public void deleteChat(SqlSessionTemplate sqlSession, MessageLog ml) {
		sqlSession.delete("chatMapper.deleteChat", ml);
	}
	
	// 채팅 로그 조회
	public ArrayList<MessageLog> selectChatLog(SqlSessionTemplate sqlSession, MessageLog ml) {
		return (ArrayList)sqlSession.selectList("chatMapper.selectChatLog", ml);
	}
	
	// 입력한 채팅 저장
	public void inputChat(SqlSessionTemplate sqlSession, Message m) {
		sqlSession.insert("chatMapper.inputChat", m);
	}

}
