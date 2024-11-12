package com.kh.hkid.community.model.vo;

import lombok.Data;

@Data // vo에 필요한 것들을 모아둔 @어노테이션
public class Reply {
	private String replyNo;		//댓글번호
	private String boardNo;		//게시글 번호
	private String memberNo;	//회원 번호
	private String replyContent;//댓글 내용
	private String replyDate;	//댓글 작성일
	private String reReplyNo;	//부모댓글 번호
}
