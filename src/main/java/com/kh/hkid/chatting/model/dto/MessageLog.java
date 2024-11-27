package com.kh.hkid.chatting.model.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MessageLog {
	private String messageId;
	private String messageContent;
	private String chatId;
	private int senderNo;
	private String nickName;
	private String profileImg;
	private Date sendTime;
}
