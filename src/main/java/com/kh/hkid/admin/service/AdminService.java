package com.kh.hkid.admin.service;

import java.util.ArrayList;

import com.kh.hkid.admin.model.vo.AccRecovery;
import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.admin.model.vo.Report;
import com.kh.hkid.admin.model.vo.SuspensionMember;
import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.common.vo.Attachment;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.BoardInfo;
import com.kh.hkid.community.model.vo.Board;
import com.kh.hkid.product.model.vo.Product;

public interface AdminService {
// 	======================= 공지 ======================= 
	int noticeCount();
	
	ArrayList<Notice> selectNoticeList(PageInfo pi);
	
	int insertNotice(Notice n);
	
	int deleteNotice(int noticeNo);
	
	Notice selectNotice(int noticeNo);
	
	int updateNotice(Notice n);
	
//  ======================= 신고 ======================= 
	int reportCount(String category);
	
	ArrayList<Report> selectReportList(PageInfo pi, String categoty);
	
	int deleteReportBoard(Report r);
	
	int deleteReportReply(Report r);
	
	void insertsuspension(SuspensionMember sm, int reportNo);
	
	Board loadBoardAjax(int boardNo);
	
// ======================= 계정복구 =======================
	int recoveryCount();
	
	ArrayList<AccRecovery> selectRecoveryList(PageInfo pi);
	
	void recoveryAccount(int memberNo);
	
// ======================= 상품 =======================
	int pCount();
	
	ArrayList<Product> selecProductList(PageInfo pi);
	
	void insertProduct(Product p, String files);
	
	Product editProduct(int productNo);
	
	int deactivateProduct(int productNo);
	
	int activateProduct(int productNo);
	
	void updateProduct(Product p, String files);
	
//	======================= 챌린지 =======================
	int challengeCount();
	
	ArrayList<Challenge> selectChallengeList(PageInfo pi);
	
	int insertChallenge(Challenge ch);
}
