package com.kh.hkid.community.model.dto;

import lombok.Data;

@Data
public class Community {
	private int boardNo;	//게시글 번호
	private String boardTitle; // 게시글 제목
	private String boardDate; // 작성일
	private int boardViewCount; // 조회수
	private String communityName; // 카테고리 이름 (조인)
	private String userName; //작성자(조인)

}