package com.kh.hkid.common.vo;

import java.sql.Date;

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
public class PageInfo {
	int listCount; //현재 총 게시글 수 
	int currentPage; //현재 페이지(사용자가 요청한 페이지) 
	int pageLimit; //페이지 하단에 보여질 페이징바의 수 
	int boardLimit; //한 페이지내에 보여질 게시글 최대갯수 
	//위 4개의 값을 기준으로 아래 3개의 값을 구할 수 있음
	
	int maxPage; //가장 마지막 페이지(총 페이지의 수)
	int startPage; //페이징바의 시작 수
	int endPage; //페이징방의 마지막 끝수
}