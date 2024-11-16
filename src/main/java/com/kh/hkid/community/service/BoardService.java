package com.kh.hkid.community.service;

import java.util.ArrayList;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.Community;

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
	
}
