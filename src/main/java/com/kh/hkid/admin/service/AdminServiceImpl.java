package com.kh.hkid.admin.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.admin.model.dao.AdminDao;
import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.common.vo.PageInfo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final AdminDao adminDao;

	
	@Override
	public int noticeCount() {
		return adminDao.noticeCount(sqlSession);
	}


	@Override
	public ArrayList<Notice> selectNotice(PageInfo pi) {
		return adminDao.selectNotice(sqlSession, pi);
	}
}
