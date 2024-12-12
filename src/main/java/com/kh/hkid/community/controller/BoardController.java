package com.kh.hkid.community.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.admin.service.AdminService;
import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.CommentReply;
import com.kh.hkid.community.model.dto.Community;
import com.kh.hkid.community.model.vo.Board;
import com.kh.hkid.community.model.vo.Reply;
import com.kh.hkid.community.service.BoardService;
import com.kh.hkid.member.model.vo.Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	private final BoardService boardService;
	private final AdminService adminService;
	
	@Autowired
	public BoardController(BoardService boardService, AdminService adminService) {
		super();
		this.boardService = boardService;
		this.adminService = adminService;
	}

	
	//인기 게시글
	@RequestMapping("/")
	public String popularCommunity(
			@RequestParam(value="cpage", defaultValue="1") int currentPage,  Model model) {
		int boardCount = boardService.selectListCount();
		
		PageInfo pi = Template.getPageInfo(boardCount, currentPage, 5, 2);
		
		ArrayList<Board> list = boardService.selectPopularCommunity(pi);
		
		System.out.println("list" + list);
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		return "main";
	}
	


	//리팩토링
	@GetMapping("list.bo")
	public String selectList(
			@RequestParam(value="cpage", defaultValue="1") int cpage, //현재 페이지
			@RequestParam(value="choiceBoardCount", defaultValue="10") int choiceBoardCount, //글 개수
			@RequestParam(value="category", defaultValue="전체") String category, //선택 카테고리
			Model model
			) {
		
		int boardCount;
		ArrayList<Community> list;
		PageInfo pi;
		//카테고리 선택 시
		if(!(category.equals("전체"))) { //카테고리가 "전체"가 아니면 모든 카테고리별 게시글 출력
			boardCount = boardService.selectCategoryListCount(category); //카테고리 게시글 개수
			pi = Template.getPageInfo(boardCount, cpage, 10, choiceBoardCount); //페이징 처리
			list = boardService.selectCategoryList(pi, category);	//게시글 리스트
		}else { //전체일 경우
			boardCount = boardService.selectListCount(); //게시글의 총 개수
			pi = Template.getPageInfo(boardCount, cpage, 10, choiceBoardCount); //페이징 처리
			list = boardService.selectList(pi); //전체 게시글
		}
		
		ArrayList<Notice> li = boardService.selectNoticeList();
		System.out.println("공지글 : "+ li);
		
		
		/*	[pageInfo] 
		 	pageInfo(현재 총 게시글 수, 사용자가 요청한 페이지, 페이징바의 개수, 보여질 게시글의 최대개수)
		*/
		model.addAttribute("pageName", "boardList");
		model.addAttribute("optional", category);
		model.addAttribute("category", category); //선택한 카테고리 띄울 때 필요함
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		model.addAttribute("nList", li); //공지 게시글
		return "community/boardList";
	}
	
	//게시글 검색
	@GetMapping("searchBoard.bo")
	public String selectSearchBoardList(
			@RequestParam(value="cpage", defaultValue="1") int cpage, //현재 페이지
			@RequestParam(value="choiceBoardCount", defaultValue="10") int choiceBoardCount, //글 개수
			@RequestParam(value="category", defaultValue="전체") String category, //선택 카테고리
			String keyword, String condition,
			Model model
			) {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("condition", condition);
		map.put("keyword", keyword);
		map.put("category", category);
		
		int searchCount = boardService.selectSearchCount(map);	//검색한 게시글의 개수
		PageInfo pi = Template.getPageInfo(searchCount, cpage, 10, choiceBoardCount);
		ArrayList<Community> list = boardService.selectSearchList(map, pi);

//		System.out.println("검색한 게시글 목록 >>>" + list);
//		System.out.println("검색한 게시글의 개수 >>>" + searchCount);
		
		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);
		model.addAttribute("category", category);
		model.addAttribute("pi", pi);
		model.addAttribute("nList", boardService.selectNoticeList()); //공지게시글
		model.addAttribute("list", list);
		return "community/boardList";
	}
	
	
	//게시글 디테일
	@RequestMapping("boardDetail.bo")
	public String selectDetailBoard(Model model, int bno, HttpSession session) {
		HashMap<String, Integer> map = new HashMap<>();
		
		// 로그인을 했을 때만 좋아요 검사
		if(((Member)session.getAttribute("loginMember")) != null) {
			int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			map.put("memberNo", memberNo);
		}else { //로그인을 안 했으면
			
		}
		Member m = (Member)session.getAttribute("loginMember");
		Integer bNo = (Integer)bno;
		map.put("boardNo", bNo);
		
		// JSON타입으로 변환해서 전달
		String jsonMap = new Gson().toJson(map);
		model.addAttribute("optional", jsonMap);
		
		//게시글 조회 + 조회수 증가
		Board b = boardService.selectBoard(bno);
		model.addAttribute("b", b);
		model.addAttribute("pageName", "boardDetail");
		model.addAttribute("m", m);
		
		return "community/boardDetail";
	}
	
	//공지 게시글
	@RequestMapping("noticeDetail.bo")
	public String selectnoticeDetail(Model model, int noticeNo, HttpSession session) {
		HashMap<String, Integer> map = new HashMap<>();
		
		// 로그인을 했을 때만 좋아요 검사
		if(((Member)session.getAttribute("loginMember")) != null) {
			int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
			map.put("memberNo", memberNo);
		}else { //로그인을 안 했으면
			
		}
		Member m = (Member)session.getAttribute("loginMember");
		Integer bNo = (Integer)noticeNo;
		map.put("noticeNo", bNo);
		
		//게시글 조회 + 조회수 증가
		Board nb = boardService.selectNotice(noticeNo);	// 공지 게시글의 쿼리 만들어서 가져오고
		System.out.println("nb: "+nb);
		
		// JSON타입으로 변환해서 전달
		String jsonMap = new Gson().toJson(map);
		model.addAttribute("optional", jsonMap);
		
		
		model.addAttribute("b", nb);						// noticeDetail.jsp으로 응답하기
//		model.addAttribute("pageName", "boardDetail");
		model.addAttribute("m", m);
		
		return "community/boardDetail";
	}
	
	
	//게시글 삭제
	@PostMapping("boardDelete.bo")
	public String boardDelete(int bno, HttpSession session, Model model) {
		if(boardService.deleteboard(bno) > 0) { //성공 시	
			session.setAttribute("alertMsg", "게시글 삭제 완료");
			return "redirect:/list.bo";
		}else {
			session.setAttribute("alertMsg", "게시글 삭제 실패");
			return "redirect:/boardDetail.bo?bno=" + bno;
		}
		//첨부파일 삭제도 추가
	}
	
	//게시글 작성
	@GetMapping("enrollForm.bo")
	public String boardWrite(Model model) {
		
		
		model.addAttribute("pageName", "enrollForm");
		return "community/boardWrite";
	}
	
	
	//게시글 추가
	@PostMapping("insert.bo")
	public String insertBoard(Board b, MultipartFile upfile, HttpSession session, Model model) {
		
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		b.setMemberNo(memberNo);
		
		//전달된 파일이 있을 경우
		if(!upfile.getOriginalFilename().equals("")) {
			String changeName = Template.saveFile(upfile, session, "/resources/uploadFile/");
			b.setChangeName("/resources/uploadFile/" + changeName);
			b.setOriginName(upfile.getOriginalFilename());
			}
		
		if(boardService.insertBoard(b) > 0) { //성공 -> list페이지로 이동
			session.setAttribute("alertMsg", "게시글 작성 성공");
		} else { //실패 -> 에러페이지
			session.setAttribute("alertMsg", "게시글 작성 실패");
		}
		model.addAttribute("pageName", "boardWrite");
		return "redirect:/list.bo";
	}
	
	
	
	//게시글 수정Form
	@RequestMapping("updateForm.bo")
	public String updateForm(int bno, Model model) {
		//게시글 조회
		Board b = boardService.selectBoard(bno);
	
		model.addAttribute("b", b);
		model.addAttribute("pageName", "updateForm");
		model.addAttribute("optional", b.getContent());
		System.out.println("카테고리 체크"+b.getCommunityNo());
		return "community/boardUpdate"; 
	}
	
	//게시글 수정
	@RequestMapping("update.bo")
	public String updateBoard(Board b, MultipartFile reupfile, HttpSession session, Model m) {
		//수정 할 첨부파일이 있을 경우
		if(!reupfile.getOriginalFilename().equals("")) {
			//기존 첨부파일이 있다 -> 기존파일을 삭제
			if(b.getOriginName() != null) {
				new File(session.getServletContext().getRealPath(b.getChangeName())).delete();
			}
			//새로운 첨부파일을 서버에 업로드하기
			String changeName = Template.saveFile(reupfile, session, "/resources/uploadFile/");
			
			b.setOriginName(reupfile.getOriginalFilename());
			b.setChangeName( "/resources/uploadFile/" + changeName);
		}
		
		//수정된 게시글 update
		if(boardService.updateBoard(b) > 0) {
			session.setAttribute("alertMsg", "게시글 수정 성공");
		}else {
			session.setAttribute("alertMsg", "게시글 수정 실패");
		}
		return "redirect:/boardDetail.bo?bno=" + b.getBoardNo(); 
	}
	

	//신고
	@PostMapping("report.bo")
	public String insertReport(int bno, int reportTypeNo, String reportDetailContent, HttpSession session) {
		HashMap<String, Object> map = new HashMap<>();
		
		System.out.println("신고 요청 Controller에서 받음");
		
		int memberNo = ((Member)session.getAttribute("loginMember")).getMemberNo();
		int reportedUserNo = boardService.selectReportedUserNo(bno); //신고당한 사람
		
		// Report vo 만들어서 하기 (수정필요)
		map.put("boardNo", bno);
		map.put("TypeNo", reportTypeNo);
		map.put("detailContent", reportDetailContent);
		map.put("memberNo", memberNo);
		map.put("reportedMemberNo", reportedUserNo);
		
		if(boardService.insertReport(map) > 0) {
			System.out.println("신고 INSERT 성공");
			session.setAttribute("alertMsg", "신고 완료");
		}else {
			System.out.println("신고 INSERT 실패");
			session.setAttribute("alertMsg", "신고 실패");
		}
		session.setAttribute("alertMsg", "신고 완료");
		return "redirect:/boardDetail.bo?bno=" + bno;
	}
		
	//=================[좋아요]================
	//좋아요 유무 체크
	@ResponseBody
	@RequestMapping(value="checkGood", produces = "application/json; charset = UTF-8")
	public int ajaxcheckGood(int boardNo, Integer memberNo) {
		// 로그인을 하지 않았을 경우 0 리턴
		if(memberNo == null) {
			return 0;
		}
		HashMap<String, Integer> map = new HashMap<>();
		
//		System.out.println("boardNo의 값: "+ boardNo);
//		System.out.println("memberNo의 값: "+ memberNo);
		
		map.put("boardNo", boardNo);
		map.put("memberNo", memberNo);
		// 좋아요의 유무 체크 (있으면 1 / 없으면 0)
		int result = boardService.checkGood(map);
		System.out.println("checkGood의 결과: "+result);
		return result;
	}
	
	//좋아요 on off
	@ResponseBody
	@RequestMapping(value="goodOnOff", produces="application/json; charset=UTF-8")
	public int goodOnOff(int boardNo, int memberNo, boolean isHeartOnOff) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("boardNo", boardNo);
		map.put("memberNo", memberNo);
		map.put("isHeartOnOff", isHeartOnOff);
		
		log.info("isHeartOnOff: " + isHeartOnOff);
		
		return boardService.updateGood(map);
	}
	
	//게시글의 좋아요 개수
	@ResponseBody
	@RequestMapping(value="countGood", produces="application/json; charset=UTF-8")
	public int countGood(int boardNo) {
//		System.out.println("보드번호: " + boardNo);
//		System.out.println("좋아요 개수: "+boardService.countGood(boardNo));
		return boardService.countGood(boardNo);
	}
	
	
//	----------------------- [댓글 기능] -------------------------
	
	//댓글추가
	@ResponseBody
	@RequestMapping("insertReply.bo")
	public int insertReply(Reply r) {
//		System.out.println("넘어온 보드 번호: "+r.getBoardNo());
//		System.out.println("넘어온 멤버 번호: "+r.getMemberNo());
//		System.out.println("넘어온 Content 내용: "+r.getReplyContent());
		
		int result = boardService.insertReply(r);
		
		if(result > 0) {
			System.out.println("댓글 INSERT 완료!");
		}else {
			System.out.println("댓글 INSERT 실패!");
		}
	    return result;
	}

	//ajax 댓글목록 select
	@ResponseBody
	@GetMapping(value="replyList.bo", produces = "application/json; charset = UTF-8") //produces="타입/서브타입"
	public String ajaxSelectReplyList(int boardNo, HttpSession session) {
		
		// 로그인하지 않았으면 0으로 설정
		Member loginMember = (Member) session.getAttribute("loginMember");
		int memberNo = (loginMember != null) ? loginMember.getMemberNo() : 0;
		
		System.out.println("memberNo: "+memberNo);
		//BNO에 해당하는 댓글 리스트 가져오기
		ArrayList<CommentReply> list = new ArrayList<>();
		list = boardService.selectReplyList(boardNo);
		HashMap <String, Object> map= new HashMap<>();
		

		map.put("replyList", list);
		map.put("loginMemberNo", memberNo);
		
		System.out.println(map);
		return new Gson().toJson(map); //list를 JSON(문자열)으로 변환해서 리턴 
	}
	
	//댓글삭제
	@ResponseBody
	@RequestMapping(value="deleteReply", produces = "application/json; charset = UTF-8")
	public int deleteReply(int boardNo, int replyNo) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("boardNo", boardNo);
		map.put("replyNo", replyNo);
		
		System.out.println("boardNo: "+boardNo);
		System.out.println("replyNo: "+replyNo);
		int result = boardService.deleteReply(map);
		System.out.println("result = "+result);
		
		if(result > 0) {
			System.out.println("댓글 DELETE 완료!");
		}else {
			System.out.println("댓글 DELETE 실패!");
		}
	    return result;
	}
	
	//댓글 수정
	@ResponseBody
	@PostMapping("updateReply.bo")
	public void updateReply(Reply r) {
		boardService.updateReply(r);
	}

	//-------------------------summernote----------------------------
	
	//ajax로 파일 업로드
	//파일목록을 저장하고 저장된 파일명 목록명을 반환
	@ResponseBody
	@PostMapping("upload")
	public String upload(List<MultipartFile> fileList, HttpSession session) {
		
		List<String> changeNameList = new ArrayList<>();
		for(MultipartFile f : fileList) {
			changeNameList.add(saveFile(f,session, "/resources/img/"));
		}
		
		return new Gson().toJson(changeNameList);
	}
	
	public String saveFile(MultipartFile upfile, HttpSession session, String path) {
		//파일 원본명
		String originName = upfile.getOriginalFilename();
		
		//확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		//년월시분초
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//5자리 랜덤값
		int randNum = (int)(Math.random()*90000) + 10000;
		String changeName = currentTime + "_" + randNum + ext;
		
		//첨부파일 저장할 폴더의 물리적 경로
		String savePath = session.getServletContext().getRealPath(path);
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
	}
	//--------------------------------------------------------------------------------

}