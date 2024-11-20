package com.kh.hkid.admin.service;

import java.util.ArrayList;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.vo.Board;

public interface AdminService {
	int noticeCount();
	
	ArrayList<Board> selectNotice(PageInfo pi);
}
