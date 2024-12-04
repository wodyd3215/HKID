package com.kh.hkid.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kh.hkid.admin.model.vo.AccRecovery;
import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.admin.model.vo.Report;
import com.kh.hkid.admin.model.vo.SuspensionMember;
import com.kh.hkid.admin.service.AdminService;
import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.member.model.vo.Member;
import com.kh.hkid.product.model.vo.Product;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {
	private final AdminService adminService;
	
	@Autowired
	public AdminController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@GetMapping("product.ad")
	public String product() {
		return "admin/productManagement";
	}
	
	@GetMapping("reportedBoard.ad")
	public String reportedBoard(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int rCount = adminService.reportCount("board");
		
		PageInfo pi = Template.getPageInfo(rCount, currentPage, 10, 10);
		
		ArrayList<Report> list = adminService.selectReportList(pi, "board");
		log.info("list: " + list);
		log.info("pi: " + pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return "admin/reportedBoard";
	}
	
	@GetMapping("reportedUser.ad")
	public String reportedUser(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int rCount = adminService.reportCount("user");
		
		PageInfo pi = Template.getPageInfo(rCount, currentPage, 10, 10);
		
		ArrayList<Report> list = adminService.selectReportList(pi, "user");
		log.info("list: " + list);
		log.info("pi: " + pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return "admin/reportedUser";
	}
	
	@GetMapping("accRecovery.ad")
	public String accRecovery(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int count = adminService.recoveryCount();
		
		PageInfo pi = Template.getPageInfo(count, currentPage, 10, 10);
		
		ArrayList<AccRecovery> list = adminService.selectRecoveryList(pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return "admin/accRecovery";
	}
	
	@GetMapping("reportedReply.ad")
	public String reportedReply(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int rCount = adminService.reportCount("reply");
		
		PageInfo pi = Template.getPageInfo(rCount, currentPage, 10, 10);
		
		ArrayList<Report> list = adminService.selectReportList(pi, "reply");
		log.info("list: " + list);
		log.info("pi: " + pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return "admin/reportedReply";
	}
	
	@GetMapping("notice.ad")
	public String notice(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int totalCount = adminService.noticeCount();
		PageInfo pi = Template.getPageInfo(totalCount, currentPage, 10, 10);
		ArrayList<Notice> list = adminService.selectNoticeList(pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return "admin/noticeManagement";
	}
	
	//상품 등록
	@GetMapping("pEnroll.ad")
	public String productEnroll(Model model) {
		model.addAttribute("pageName", "pEnroll");
		
		return "admin/productEnroll";
	}
	
	@GetMapping("nEnroll.ad")
	public String noticeEnroll(Model model) {
		model.addAttribute("pageName", "nEnroll");
		
		return "admin/noticeEnroll";
	}
	
	@PostMapping("insertNotice") 
	public String insertNotice(Notice n, HttpSession session) {
		n.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
		
		int result = adminService.insertNotice(n);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "공지 작성 성공");
		} else {
			session.setAttribute("alertMsg", "공지 삭제 실패");
		}
		
		return "redirect:/notice.ad";
	}
	
	@PostMapping("deleteNotice")
	public String deleteNotice(int noticeNo, HttpSession session) {
		int result = adminService.deleteNotice(noticeNo);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "공지 삭제 성공");
		} else {
			session.setAttribute("alertMsg", "공지 삭제 실패");
		}
		
		return "redirect:/notice.ad";
	}
	
	@PostMapping("editNotice")
	public String editNotice(int noticeNo, Model model) {
		Notice n = adminService.selectNotice(noticeNo);
		
		model.addAttribute("notice", n);
		model.addAttribute("pageName", "nEnroll");
		model.addAttribute("optional", n.getNoticeContent());
		
		return "admin/noticeUpdateForm";
	}
	
	@PostMapping("updateNotice")
	public String updateNotice(Notice n, HttpSession session) {
		n.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
		
		int result = adminService.updateNotice(n);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "공지 수정 완료");
			return "redirect:/notice.ad";
		} else {
			session.setAttribute("alertMsg", "공지 수정 실패");
			return "redirect:/editNotice";
		}
	}
	
	@PostMapping("deleteReportB")
	public String deleteReportB(Report r, HttpSession session) {
		int result = adminService.deleteReportTarget(r);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "신고 게시물 삭제 완료");
		} else {
			session.setAttribute("alertMsg", "신고 게시물 삭제 실패");
		}
		
		return "redirect:/reportedBoard.ad";
	}
	
	@PostMapping("deleteReportR")
	public String deleteReportR(Report r, HttpSession session) {
		int result = adminService.deleteReportTarget(r);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "신고 댓글 삭제 완료");
		} else {
			session.setAttribute("alertMsg", "신고 댓글 삭제 실패");
		}
		
		return "redirect:/reportedReply.ad";
	}
	
	
	@SuppressWarnings("finally") // 자바 컴파일러가 finally 블록 관련 경고를 무시하도록 지시하는 주석 
	@PostMapping("suspensionMember")
	public String insertsuspension(SuspensionMember sm, int reportNo, HttpSession session) {
		sm.setSuspensionComment("그냥 정지당해라");
		
		try {
			adminService.insertsuspension(sm, reportNo);
			session.setAttribute("alertMsg", "유저 정지 성공");
		} catch(RuntimeException e) {
			session.setAttribute("alertMsg", "유저 정지 실패");
		} finally {
			return "redirect:/reportedUser.ad";
		}
	}
	
	@SuppressWarnings("finally")
	@PostMapping("recoveryAccount.ad")
	public String recoveryAccount(int memberNo, HttpSession session) {
		try {
			adminService.recoveryAccount(memberNo);
			session.setAttribute("alertMsg", "계정 복구 성공");
		} catch(RuntimeException e) {
			session.setAttribute("alertMsg", "계정 복구 실패");
		} finally {
			return "redirect:/accRecovery.ad";
		}
	}
	
	@ResponseBody
	@PostMapping("insertProduct")
	public String insertProduct(Product p, List<MultipartFile> fileList, HttpSession session) {
		p.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
		
		for(MultipartFile file : fileList) {
			String changeName = 
		}
		
		try {
			adminService.insertProduct(p);
			
			return "success";
		} catch(RuntimeException e) {
			return "false";
		}
	}
	
//	@ResponseBody
//	@PostMapping(value="loadBoardAjax",  produces="application/json; charset=UTF-8")
//	public String loadBoardAjax(int boardNo, Model model) {
//		
//		
//		return new Gson().toJson(adminService.loadBoardAjax(boardNo));
//	}
}
