package com.kh.hkid.community.service;

import java.util.ArrayList;

import com.kh.hkid.community.model.vo.Board;

public interface BoardService {
	
	//게시글 갯수
	int selectListCount();
	
	//게시글 목록
	ArrayList<Board> selectList();

}
