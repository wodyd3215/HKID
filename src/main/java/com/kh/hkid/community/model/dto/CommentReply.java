package com.kh.hkid.community.model.dto;

import lombok.Data;

@Data
public class CommentReply {
	private int boardNo;	//게시글 번호
	private int memberNo;	//회원 번호
	private int replyNo;		//댓글번호
	private String content;	//댓글 내용
	private String date;	//댓글 작성일
	private int reReplyNo;	//부모댓글 번호
	private String nickName;//사용자 닉네임
}

