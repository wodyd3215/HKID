package com.kh.hkid.admin.model.vo;

import lombok.Data;

@Data
public class Report {
	private int reportNo;
	private int typeNo;
	private String reportDate;
	private String detailContent;
	private int memberNo;
	private int reportedMemberNo;
	private int replyNo;
	private int boardNo;
	private int reviewNo;
	private String typeContent;
	private String nickname;
	private String reportedNickname;
	private String replyContent;
	private String boardTitle;
	private String reviewContent;
}