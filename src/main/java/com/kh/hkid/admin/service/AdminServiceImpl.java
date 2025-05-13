package com.kh.hkid.admin.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.hkid.admin.model.dao.AdminDao;
import com.kh.hkid.admin.model.vo.AccRecovery;
import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.admin.model.vo.Report;
import com.kh.hkid.admin.model.vo.SuspensionMember;
import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.vo.Board;
import com.kh.hkid.product.model.vo.Product;

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

	@Override
	public int reportCount(String category) {
		return adminDao.reportCount(sqlSession, category);
	}

	@Override
	public ArrayList<Report> selectReportList(PageInfo pi, String categoty) {
		return adminDao.selectReportList(sqlSession, pi, categoty);
	}

	@Override
	public int deleteReportBoard(Report r) {
		return adminDao.deleteReportBoard(sqlSession, r);
	}
	
	@Override
	public int deleteReportReply(Report r){
		return adminDao.deleteReportReply(sqlSession, r);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int insertsuspension(SuspensionMember sm, int reportNo) {
		int result1 = adminDao.insertsuspension(sqlSession, sm);
		if(result1 == 0)
			throw new RuntimeException("리스트에 정상적으로 insert되지 않았습니다.");
		
		int result2 = adminDao.updateStatus(sqlSession, sm);
		if(result2 == 0)
			throw new RuntimeException("유저정보가 정상적으로 update되지 않았습니다.");
		
		int result3 = adminDao.deleteReport(sqlSession, reportNo);
		if(result3 == 0) 
			throw new RuntimeException("신고 정보가 정상적으로 delete되지 않았습니다");
		
		return result1 * result2 * result3;
	}

	@Override
	public int recoveryCount() {
		return adminDao.recoveryCount(sqlSession);
	}

	@Override
	public ArrayList<AccRecovery> selectRecoveryList(PageInfo pi) {
		return adminDao.selectRecoveryList(sqlSession, pi);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int recoveryAccount(int memberNo) {
		int result1 = adminDao.recoveryAccount(sqlSession, memberNo);
		if(result1 == 0)
			throw new RuntimeException("계정 정보를 정상적으로 update하지 못하였습니다.");
		
		int result2 = adminDao.deleteRecovery(sqlSession, memberNo);
		if(result2 == 0)
			throw new RuntimeException("신청서를 정상적으로 delete하지 못하였습니다.");
		
		return result1 * result2;
	}
	
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int insertProduct(Product p, String files) {
		int result1 = adminDao.insertProduct(sqlSession, p);
		if(result1 == 0)
			throw new RuntimeException("상품을 정상적으로 insert하지 못하였습니다.");
		
		int result2 = adminDao.insertAttachment(sqlSession, files);
		if(result2 == 0)
			throw new RuntimeException("이미지를 정상적으로 insert하지 못하였습니다.");
		
		return result1 * result2;
	}
	
	public Product editProduct(int productNo) {
		return adminDao.editProduct(sqlSession, productNo);
	}

	@Override
	public int deactivateProduct(int productNo) {
		return adminDao.deactivateProduct(sqlSession, productNo);
	}
	
	@Override
	public int activateProduct(int productNo) {
		return adminDao.activateProduct(sqlSession, productNo);
	}
	
	@Transactional(rollbackFor = {Exception.class})
	@Override
	public int updateProduct(Product p, String files) {
		HashMap<String, Object> aMap = new HashMap<>();
		
		aMap.put("productNo", p.getProductNo());
		aMap.put("files", files);
		
		int result1 = adminDao.updateAttachment(sqlSession, aMap);
		if(result1 == 0)
			throw new RuntimeException("상품을 정상적으로 insert하지 못하였습니다.");
		
		int result2 = adminDao.updateProduct(sqlSession, p);
		if(result2 == 0)
			throw new RuntimeException("상품을 정상적으로 insert하지 못하였습니다.");
		
		return result1 * result2;
	}

	@Override
	public int challengeCount() {
		return adminDao.challengeCount(sqlSession);
	}

	@Override
	public ArrayList<Challenge> selectChallengeList(PageInfo pi) {
		return adminDao.selectChallengeList(sqlSession, pi);
	}
	
	@Override
	public int insertChallenge(Challenge ch) {
		return adminDao.insertChallenge(sqlSession, ch);
	}
	
	@Override
	public Board loadBoardAjax(int boardNo) {
		return adminDao.loadBoardAjax(sqlSession, boardNo);
	}

	@Override
	public int pCount() {
		return adminDao.pCount(sqlSession);
	}

	@Override
	public ArrayList<Product> selecProductList(PageInfo pi) {
		return adminDao.selecProductList(sqlSession, pi);
	}
	
}
