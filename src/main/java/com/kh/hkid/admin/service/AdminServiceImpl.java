package com.kh.hkid.admin.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.kh.hkid.admin.model.dao.AdminDao;
import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.admin.model.vo.Report;
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

	@Transactional
	@Override
	public Notice selectNotice(int noticeNo) {
		return adminDao.selectNotice(sqlSession, noticeNo);
	}

	@Override
	public int updateNotice(Notice n) {
		return adminDao.updateNotice(sqlSession, n);
	}

	@Override
	public int reportCount(String category) {
		return adminDao.reportCount(sqlSession, category);
	}

	@Override
	public ArrayList<Report> selectReportList(PageInfo pi, String categoty) {
		return adminDao.selectReportList(sqlSession, pi, categoty);
	}

	@Override
	public int deleteReport(Report r){
		if(adminDao.deleteReport(sqlSession, r) > 0) {
			return adminDao.deleteReportTarget(sqlSession, r);
		}

		return 0;
	}
	
	
}
