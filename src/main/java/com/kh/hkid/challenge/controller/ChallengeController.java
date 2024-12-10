package com.kh.hkid.challenge.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.challenge.model.vo.ChallengeBoard;
import com.kh.hkid.challenge.service.ChallengeService;
import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.vo.Board;
import com.kh.hkid.member.model.vo.Member;

@Controller
public class ChallengeController {
	private final ChallengeService challengeService;
	
	@Autowired
	public ChallengeController(ChallengeService challengeService) {
		this.challengeService = challengeService;
		
	}
	
	@RequestMapping("ch.m")
	public String challenge(@RequestParam(value="cpage", defaultValue="1") int currentPage, Model model) {
		int boardCount = challengeService.boardCount();
		
		PageInfo pi = Template.getPageInfo(boardCount, currentPage, 5, 6);
		
		ArrayList<Challenge> list = challengeService.selectList(pi);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "challenge/challengeM";
	}
	
	@RequestMapping("ch.b")
	public String challengeBoard(
			@RequestParam(value="cpage", defaultValue="1") Integer currentPage,
			@RequestParam(value="choiceBoardCount", defaultValue="10") int choiceBoardCount, //글 개수
			@RequestParam(value = "cno") int cno,
			Model model) {
		int challengeBoardCount = challengeService.challengeBoardCount(cno);
		
		Challenge c = challengeService.selectName(cno);
		
		PageInfo pi = Template.getPageInfo(challengeBoardCount, currentPage, 10, choiceBoardCount);
		
		ArrayList<ChallengeBoard> list = challengeService.chBoardselectList(cno, pi);
		ArrayList<Notice> nlist = challengeService.selectNoticeList(pi);
		
		model.addAttribute("nlist", nlist);
		model.addAttribute("cno", cno);
		model.addAttribute("c", c);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);

		return "challenge/challengeD";
	}
	
	@GetMapping("searchBoard.ch")
	   public String searchBoardChallenge(
	         @RequestParam(value="cpage", defaultValue="1") Integer currentPage, //현재 페이지
	         @RequestParam(value="choiceBoardCount", defaultValue="10") int choiceBoardCount, //글 개수
	         @RequestParam(value = "cno") int cno, 
	         String keyword, String condition, Model model
	         ) {
	      
	      HashMap<String, Object> map = new HashMap<>();
	      map.put("condition", condition);
	      map.put("keyword", keyword);
	      map.put("cno", cno);
	      
	      int searchCount = challengeService.selectSearchCount(map);   //검색한 게시글의 개수
	      PageInfo pi = Template.getPageInfo(searchCount, currentPage, 10, choiceBoardCount);
	      ArrayList<ChallengeBoard> list = challengeService.selectSearchList(map, pi);
	      
	      model.addAttribute("cno", cno);
	      model.addAttribute("condition", condition);
	      model.addAttribute("keyword", keyword);
	      model.addAttribute("pi", pi);
	      model.addAttribute("list", list);
	      return "challenge/challengeD";
	   }
	
	@RequestMapping("cboardDetail.bo")
	   public String selectDetailChallengeBoard(int cbno, Model model, HttpSession session) {
		
		Member m = (Member)session.getAttribute("loginMember");
		
		ChallengeBoard c = challengeService.selectBoard(cbno);
		model.addAttribute("c", c);
		model.addAttribute("pageName", "cboardDetail");
		model.addAttribute("m", m);
		
	      
	      return "challenge/cboardDetail";
	   }
	
	//게시글 작성
	@GetMapping("cenrollForm.bo")
	public String boardWrite(
			@RequestParam("cno") int cno,
			Model model) {
			
	model.addAttribute("pageName", "enrollForm");
	model.addAttribute("cno", cno);
	
	System.out.println("cno: " + cno); // 디버깅 로그
		return "challenge/cboardWrite";
	}
	
	//게시글 추가
		@PostMapping("insert.cbo")
		public String insertBoard(
				@RequestParam("cno") int cno,
				ChallengeBoard c, MultipartFile upfile, HttpSession session, Model m) {
			
			int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			c.setMemberNo(memberNo);
			c.setChallengeNo(cno);
			System.out.println("cno: " + cno); // 디버깅 로그
			System.out.println("로그인된 memberNo: " + memberNo);
			System.out.println("챌린지 번호: " + c.getChallengeNo());
			
			
			//전달된 파일이 있을 경우
			if(!upfile.getOriginalFilename().equals("")) {
				String changeName = Template.saveFile(upfile, session, "/resources/uploadFile/");
				c.setChangeName("/resources/uploadFile/" + changeName);
				c.setOriginName(upfile.getOriginalFilename());
				}
			
			if(challengeService.insertBoard(c) > 0) { //성공 -> list페이지로 이동
				session.setAttribute("alertMsg", "게시글 작성 성공");
			} else { //실패 -> 에러페이지
				session.setAttribute("alertMsg", "게시글 작성 실패");
			}
			return "redirect:/ch.b?cno=" + cno;
		}
		
		//게시글 수정Form
		@RequestMapping("updateForm.cbo")
		public String updateForm(int cbno, Model model) {
			//게시글 조회
			ChallengeBoard c = challengeService.selectBoard(cbno);
		
			model.addAttribute("c", c);
			model.addAttribute("pageName", "updateForm");
			model.addAttribute("optional", c.getChaContent());
			return "challenge/cboardUpdate"; 
		}	
	
		//게시글 수정
		@RequestMapping("update.cbo")
		public String updateBoard(ChallengeBoard c, MultipartFile reupfile, HttpSession session, Model m) {
			//수정 할 첨부파일이 있을 경우
			if(!reupfile.getOriginalFilename().equals("")) {
				//기존 첨부파일이 있다 -> 기존파일을 삭제
				if(c.getOriginName() != null) {
					new File(session.getServletContext().getRealPath(c.getChangeName())).delete();
				}
				//새로운 첨부파일을 서버에 업로드하기
				String changeName = Template.saveFile(reupfile, session, "/resources/uploadFile/");
				
				c.setOriginName(reupfile.getOriginalFilename());
				c.setChangeName( "/resources/uploadFile/" + changeName);
			}
			
			System.out.println("c" + c);
			
			//수정된 게시글 update
			if(challengeService.updateBoard(c) > 0) {
				session.setAttribute("alertMsg", "게시글 수정 성공");
			}else {
				session.setAttribute("alertMsg", "게시글 수정 실패");
			}
			return "redirect:/ch.b?cno=" + c.getChallengeNo();
		}
		
	

}
