package com.kh.hkid.community.model.vo;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String boardName;
	private String boardDate;
	private int boardViewCount;
	private String boardStatus;
	private int communityNo;
	private int memberNo;
	private String memberName;
	private String content;
}
