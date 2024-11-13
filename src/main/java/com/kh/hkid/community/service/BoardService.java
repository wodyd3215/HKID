package com.kh.hkid.community.service;

import java.util.ArrayList;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.Community;

public interface BoardService {
	
	//게시글 갯수
	int selectListCount();
	
	//게시글 목록
	ArrayList<Community> selectList(PageInfo pi);

}
