package com.kh.hkid.community.model.vo;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardDate;
	private int boardViewCount;
	private String boardStatus;
	private int communityNo;
	private int memberNo;
	private String nickName;
	private String content;
}
