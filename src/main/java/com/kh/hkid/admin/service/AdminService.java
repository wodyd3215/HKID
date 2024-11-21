package com.kh.hkid.admin.service;

import java.util.ArrayList;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.Community;

public interface AdminService {
	int noticeCount();
	
	ArrayList<Community> selectNotice(PageInfo pi);
}
