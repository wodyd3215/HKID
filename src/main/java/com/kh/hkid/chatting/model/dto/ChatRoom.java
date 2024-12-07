package com.kh.hkid.chatting.model.dto;

import lombok.Data;

@Data
public class ChatRoom {
	private String chatId;
	private int senderNo;
	private int receiverNo;
	private String nickName;
	private String profileImg;
}
