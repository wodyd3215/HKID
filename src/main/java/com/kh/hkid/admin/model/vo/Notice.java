package com.kh.hkid.admin.model.vo;

import lombok.Data;

@Data
public class Notice {
	private int noticeNo;
	private int memberNo;
	private String noticeTitle;
	private String noticeContent;
	private String noticeDate;
	private int viewCount;
	private int noticeType;
	private String noticeStatus;
	private String nickName;
	private String noticeTypeName;
}
