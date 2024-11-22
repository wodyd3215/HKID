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
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		return adminDao.selectNoticeList(sqlSession, pi);
	}


	@Override
	public int insertNotice(Notice n) {
		return adminDao.insertNotice(sqlSession, n);
	}


	@Override
	public int deleteNotice(int noticeNo) {
		return adminDao.deleteNotice(sqlSession, noticeNo);
	}


	@Override
	public Notice selectNotice(int noticeNo) {
		return adminDao.selectNotice(sqlSession, noticeNo);
	}


	@Override
	public int updateNotice(Notice n) {
		return adminDao.updateNotice(sqlSession, n);
	}
	
	
}
