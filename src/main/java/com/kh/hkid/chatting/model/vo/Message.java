package com.kh.hkid.chatting.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Message {
	private String messageId;
	private int senderNo;
	private int receiverNo;
	private String messageContent;
	private Date sendTime;
}
