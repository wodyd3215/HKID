package com.kh.hkid.community.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.Community;
import com.kh.hkid.community.model.vo.Board;

public interface BoardService {
	
	//게시글 개수
	int selectListCount();
	
	//게시글 목록
	ArrayList<Community> selectList(PageInfo pi);

	//카테고리 게시글 개수
	int selectCategoryListCount(String category);
	
	//카테고리 게시글 목록
	ArrayList<Community> selectCategoryList(PageInfo pi, String category);
	
	//공지글 목록
	ArrayList<Community> selectNoticeList();
	
	//검색게시글 개수
	int selectSearchCount(HashMap<String, String> map);
	
	//검색게시글  목록
	ArrayList<Community> selectSearchList(HashMap<String, String> map, PageInfo pi);
	
	//게시글 조회
	Board selectBoard(int bno);
	
	//게시글 삭제
	int deleteboard(int bno);
	
	//신고당한 게시글의 userNo찾기
	int selectReportedUserNo(int bno);
	
	//게시글 신고
	int insertReport(HashMap<String, Object> map);
	
	//게시글 추가
	int insertBoard(int bno);
}

