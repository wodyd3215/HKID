package com.kh.hkid.admin.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.hkid.admin.model.vo.AccRecovery;
import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.admin.model.vo.Report;
import com.kh.hkid.admin.model.vo.SuspensionMember;
import com.kh.hkid.admin.service.AdminService;
import com.kh.hkid.challenge.model.vo.Challenge;
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
	
	@RequestMapping("product.ad")
	public String product(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int pCount = adminService.pCount();
		
		PageInfo pi = Template.getPageInfo(pCount, currentPage, 10, 10);
		ArrayList<Product> list = adminService.selecProductList(pi);

		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		log.info("list" + list);
		log.info("pi" + pi);
		
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
	
	
	// 신고
	@PostMapping("deleteReportB")
	public String deleteReportB(Report r, HttpSession session) {
		int result = adminService.deleteReportBoard(r);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "신고 게시물 삭제 완료");
		} else {
			session.setAttribute("alertMsg", "신고 게시물 삭제 실패");
		}
		
		return "redirect:/reportedBoard.ad";
	}
	
	@PostMapping("deleteReportR")
	public String deleteReportR(Report r, HttpSession session) {
		int result = adminService.deleteReportReply(r);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "신고 댓글 삭제 완료");
		} else {
			session.setAttribute("alertMsg", "신고 댓글 삭제 실패");
		}
		
		return "redirect:/reportedReply.ad";
	}
	
	
	// @SuppressWarnings("finally") // 자바 컴파일러가 finally 블록 관련 경고를 무시하도록 지시하는 주석 
	@PostMapping("suspensionMember")
	public String insertsuspension(SuspensionMember sm, int reportNo, HttpSession session) {
		String message;
		try {
			int result = adminService.insertsuspension(sm, reportNo);
			message = (result > 0) ? "유저 정지 성공" : "유저 정지 실패";
		} catch(RuntimeException e) {
			e.printStackTrace();
			message = "유저 정지 실패";
		}
		
		session.setAttribute("alertMsg", message);
		return "redirect:/reportedUser.ad";
	}
	
	@PostMapping("recoveryAccount.ad")
	public String recoveryAccount(int memberNo, HttpSession session) {
		String message;
		try {
			int result = adminService.recoveryAccount(memberNo);
			message = (result > 0) ? "계정 복구 성공" : "계정 복구 실패";
		} catch(RuntimeException e) {
			e.printStackTrace();
			message = "계정 복구 실패";
		}
		
		session.setAttribute("alertMsg", message);
		return "redirect:/accRecovery.ad";
	}
	
	@ResponseBody
	@PostMapping("insertProduct")
	public String insertProduct(Product p, List<MultipartFile> fileList, HttpSession session) {
		p.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
		
		ArrayList<String> list = new ArrayList<>();
		
		for(MultipartFile file : fileList) {
			String changeName = Template.saveFile(file, session, "/resources/image/product/");
			
			list.add("/resources/image/product/" + changeName);
		}
		
		String files = String.join(",", list);
		
		log.info(files);
		
		int result = 0;
		try {
			result = adminService.insertProduct(p, files);
		} catch(RuntimeException e) {
			e.printStackTrace();
		}
		
		return (result > 0) ? "success" : "fail";
	}
	
	@PostMapping("editProduct")
	public String editProduct(int productNo, Model model) {
		Product product = adminService.editProduct(productNo);
		
		model.addAttribute("p", product);
		model.addAttribute("pageName", "pEnroll");
		model.addAttribute("optional", product.getContent());
		
		return "admin/productUpdateForm";
	}
	
	@PostMapping("deleteProduct")
	public String deactivateProduct(int productNo, String status, HttpSession session) {
		int result; 
		if(status.equals("Y")) {
			result = adminService.deactivateProduct(productNo);
		} else {
			result = adminService.activateProduct(productNo);
		}

		if(result > 0) {
			session.setAttribute("alertMsg", "상품 상태 변화 성공");
		} else {
			session.setAttribute("alertMsg", "상품 상태 변화 실패");
		}
		
		return "redirect:/product.ad";
		
	}
	
	// 등록된 상품을 수정하는 함수
	@ResponseBody
	@PostMapping("updateProduct")
	public String updateProduct(Product p, 
								@RequestParam(value = "fileList", required = false)List<MultipartFile> fileList, 
								@RequestParam(value = "srcList", required = false)List<String> srcList, 
								HttpSession session) {
		p.setMemberNo(((Member)session.getAttribute("loginMember")).getMemberNo());
		
		ArrayList<String> list = new ArrayList<>();
		
		if(srcList != null && !srcList.isEmpty()) {
			for(String src : srcList) {
				list.add(src);
			}
		}
		
		if(fileList != null && !fileList.isEmpty()) {
			for(MultipartFile file : fileList) {
				String changeName = Template.saveFile(file, session, "/resources/image/product/");
				
				list.add("/resources/image/product/" + changeName);
			}
		}

		String files = String.join(",", list);
		int result = 0;
		
		try {
			result = adminService.updateProduct(p, files);
		} catch(RuntimeException e) {
			e.printStackTrace();
		}	
		
		return (result > 0) ? "success" : "fail";
	}
	
	// 챌린지 목록을 불러오는 함수
	@GetMapping("challenges")
	public String challenges(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int totalCount = adminService.challengeCount();
		PageInfo pi = Template.getPageInfo(totalCount, currentPage, 10, 10);
		ArrayList<Challenge> list = adminService.selectChallengeList(pi);
		
		log.info("list: " + list);
		log.info("pi: " + pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		
		return "admin/challengeManagement";
	}
	
	// 챌린지를 추가하는 함수
	@ResponseBody
	@PostMapping("insertChallenge")
	public String insertChallenge(Challenge ch, MultipartFile upfile, HttpSession session) {
		
		// 전달된 파일이 있는지 확인하는 구문
		if(!upfile.getOriginalFilename().equals("")) {
			String changeName = Template.saveFile(upfile, session, "/resources/image/challenge/");
			
			ch.setThumbnail("/resources/image/challenge/" + changeName);
		}
		
		int result = adminService.insertChallenge(ch);
		
		if(result > 0) {
			return "success";
		} else {
			return "fail";
		}
	}
	
	@ResponseBody
	@PostMapping(value="loadBoardAjax",  produces="application/json; charset=UTF-8")
	public String loadBoardAjax(int boardNo, Model model) {
		
		
		return new Gson().toJson(adminService.loadBoardAjax(boardNo));
	}
	
}
