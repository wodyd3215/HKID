package com.kh.hkid.chatting.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Message {
	private String messageId;
	private String chatId;
	private int senderNo;
	private String messageContent;
	private Date sendTime;
}
