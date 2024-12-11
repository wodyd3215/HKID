package com.kh.hkid.challenge.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Notice {

	private int noticeNo;
	private int memberNo;
	private String noticeTitle;
	private String noticeContent;
	private String enrollDate;
	private int viewCount;
	private int CategoryNo;
	private String noticeStatus;
	
}
