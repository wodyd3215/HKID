package com.kh.hkid.chat;

import lombok.Data;

@Data
public class MsgVo {
	private int senderNo;
	private int receiverNo;
	private int mSenderNo;
	private String msg;
	private String nick;
	private String profileImg;
	private String targetNick;
	private String time;
}
