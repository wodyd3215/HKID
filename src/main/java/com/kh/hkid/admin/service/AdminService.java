package com.kh.hkid.admin.service;

import java.util.ArrayList;

import com.kh.hkid.admin.model.vo.AccRecovery;
import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.admin.model.vo.Report;
import com.kh.hkid.admin.model.vo.SuspensionMember;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.BoardInfo;
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
	
	int deleteReportTarget(Report r);
	
	void insertsuspension(SuspensionMember sm, int reportNo);
	
// ======================= 계정복구 =======================
	int recoveryCount();
	
	ArrayList<AccRecovery> selectRecoveryList(PageInfo pi);
	
	void recoveryAccount(int memberNo);
	
// ======================= 상품 =======================
	void insertProduct(Product p);
}
