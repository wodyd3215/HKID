package com.kh.hkid.chat;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kh.hkid.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // 클래스 이름이 (ChatServer)라면 bean에 등록된 이름은 앞글자를 소문자로 변경해서 (chatServer-카멜케이스)로 저장
public class ChatServer extends TextWebSocketHandler{

	// 스레드에서 동시에 접근할 수 있는 공유데이터를 사용할 때는 접근할 때 락을 걸어주는 ConcurrentHashMap을 사용한다.
	private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();

	// 클라이언트가 연결을 맺을 때 호출이되는 메서드
	@Override // WebSocketSession은 HttpSession과 같은 역할을 하지만 중간에 interceptor가 Http객체를 websocket객체로 변환
	// socket객체와 session이 스트림을 공유(연결)하여 데이터를 서로 전송할 수 있게 됨
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		Member m = (Member)session.getAttributes().get("loginMember");
		String nick = m.getNickName();
		System.out.println("닉네임ㅋㅋ : " + nick);
		log.info("{} 연결됨...");
		
		userSessions.put(nick, session);
	}

	// 클라이언트로부터 메세지를 받을 때 호출되는 메서드
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// 세션에 저장되어있는 발신자의 닉네임 가져오기
		System.out.println("???");
		Member m = (Member)session.getAttributes().get("loginMember");
		String nick = m.getNickName();
		String profileImg = m.getProfileImg();
		int mSenderNo = m.getMemberNo();
		
		System.out.println("여기까지 왔나?");
		
		// 클라이언트가 보낸 문자열 데이터를 getPayload()가 가져와서 JsonParser()로 Json형식으로 파싱 후 getAsJsonObject()로 Json객체 형태로 받아서 저장.
		JsonObject obj = new JsonParser().parse(message.getPayload()).getAsJsonObject(); 
		
		log.info("message : {}", obj.get("message").getAsString());
		log.info("target : {}", obj.get("target").getAsString());
		
		MsgVo vo = new MsgVo();
		vo.setMsg(obj.get("message").getAsString()); // 메세지
		vo.setNick(nick); // 발신자
		vo.setSenderNo(obj.get("senderNo").getAsInt());
		vo.setReceiverNo(obj.get("receiverNo").getAsInt());
		vo.setMSenderNo(mSenderNo);
		vo.setProfileImg(profileImg); // 발신자 프로필
		vo.setTargetNick(obj.get("target").getAsString()); // 수신자
		vo.setTime(new Date().toLocaleString()); // 발신 시간
		
		sendMessageuser(vo);
		log.info("수신자 닉네임 : {}", vo.getTargetNick());
		log.info("현재 저장된 세션들: {}", userSessions.keySet());
		
	}
	
	// 특정 사용자에게 메세지를 전송하는 메서드
	private void sendMessageuser(MsgVo vo) {
	    log.info("발신자 : {}", vo.getNick());
	    log.info("수신자 : {}", vo.getTargetNick());

	    // 발신자 세션 정보 가져오기
	    WebSocketSession mySession = userSessions.get(vo.getNick());
	    // 수신자 세션 정보 가져오기
	    WebSocketSession targetSession = userSessions.get(vo.getTargetNick());
	    
	    log.info("발신자 session : {}", mySession);
	    log.info("수신자 session : {}", targetSession);

	    // 메시지 전송 준비
	    String str = new Gson().toJson(vo);
	    TextMessage msg = new TextMessage(str);

	    try {
	        // 발신자에게만 메시지 전송
	        if (mySession != null && mySession.isOpen()) {
	            mySession.sendMessage(msg);  // 발신자에게 메시지 전송
	        }

	        // 수신자에게만 메시지 전송
	        if (targetSession != null && targetSession.isOpen()) {
	            targetSession.sendMessage(msg);  // 수신자에게 메시지 전송
	        }
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	// 클라이언트가 연결을 끊을 때 호출되는 메서드
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}

}
 