package com.kh.hkid.admin.service;

import java.util.ArrayList;

import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.admin.model.vo.Report;
import com.kh.hkid.common.vo.PageInfo;

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
	
	int deleteReport(Report r);
}
