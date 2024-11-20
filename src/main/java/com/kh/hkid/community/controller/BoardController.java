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
import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.CommentReply;
import com.kh.hkid.community.model.dto.Community;
import com.kh.hkid.community.model.vo.Board;
import com.kh.hkid.community.model.vo.Reply;
import com.kh.hkid.community.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		super();
		this.boardService = boardService;
	}
	
	//리팩토링
	@GetMapping("list.bo")
	public String selectList(
			@RequestParam(value="cpage", defaultValue="1") int cpage, //현재 페이지
			@RequestParam(value="choiceBoardCount", defaultValue="10") int choiceBoardCount, //글 개수
			@RequestParam(value="category", defaultValue="전체") String category, //선택 카테고리
			Model model
			) {
		
		int boardCount = boardService.selectListCount(); //게시글의 총 개수
		System.out.println("게시글의 총 개수: " + boardCount);
		PageInfo pi = Template.getPageInfo(boardCount, cpage, 10, choiceBoardCount); //페이징 처리
		ArrayList<Community> list = boardService.selectList(pi); //전체 게시글
		System.out.println("게시글 리스트: " + list);
		
		//카테고리 선택 시
		if(!category.equals("전체")) { //카테고리 선택이 안 됐으면 전체 게시글
			boardCount = boardService.selectCategoryListCount(category); //카테고리 게시글 개수
			pi = Template.getPageInfo(boardCount, cpage, 10, choiceBoardCount); //페이징 처리
			list = boardService.selectCategoryList(pi, category);	//게시글 리스트
			System.out.println("카테고리 게시글 리스트: " + list);
		}
		
		/*	[pageInfo] 
		 	pageInfo(현재 총 게시글 수, 사용자가 요청한 페이지, 페이징바의 개수, 보여질 게시글의 최대개수)
		*/
		
		model.addAttribute("category", category); //선택한 카테고리 띄울 때 필요함
		model.addAttribute("pi", pi);
		model.addAttribute("list", list);
		model.addAttribute("nList", boardService.selectNoticeList()); //공지 게시글
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

		System.out.println("검색한 게시글 목록 >>>" + list);
		System.out.println("검색한 게시글의 개수 >>>" + searchCount);
		
		model.addAttribute("condition", condition);
		model.addAttribute("keyword", keyword);
		model.addAttribute("category", category);
		model.addAttribute("pi", pi);
		model.addAttribute("nList", boardService.selectNoticeList()); //공지게시글
		model.addAttribute("list", list);
		return "community/boardList";
	}
	
	
	//게시글 디테일
	@GetMapping("boardDetail.bo")
	public String selectDetailBoard(Model model, int bno) {
		
		//게시글 조회
		Board b = boardService.selectBoard(bno);
	
		
		
		
		model.addAttribute("b", b);
		return "community/boardDetail";
	}
		

		
		

	
	//게시글 작성
	@GetMapping("boardWrite.bo")
	public String boardWrite() {
		
		return "community/boardWrite";
	}
	
	//게시글 수정
	@PostMapping("updateForm.bo")
	public String updateForm() {
		
		return "community/boardDetail"; 
	}
	
	//게시글 삭제
	@PostMapping("boardDelete.bo")
	public String boardDelete() {
		System.out.println("삭제컨트롤러에서 받음");
		return "community/boardDetail"; // 임시로 설정
	}
	

	
	
//	--------------- 댓글 기능 -------------------------
	
	//댓글추가
	@ResponseBody
	@RequestMapping("insertReply.bo")
//	@PostMapping(value="insertReply.bo", produces="application/json; charset-UTF-8")
	public String ajaxInsertReply(Reply r) {
	    // 처리 후 JSON 형식의 응답 반환
	    return "success";
	}
	
	//처음 댓글 목록 출력

	//ajax 댓글목록 select
	@ResponseBody
	@GetMapping(value="replyList.bo", produces = "application/json; charset = UTF-8") //produces="타입/서브타입"
	public String ajaxSelectReplyList(int bno) {
		//DB들어가면 사용 ㄱㄱ
		ArrayList<CommentReply> list = new ArrayList<>();
		
		//DB 들어가기 전까지만 사용!!
		CommentReply commentList1 = new CommentReply();
		commentList1.setContent("댓글 더미데이터입니다");
		commentList1.setDate("2024.11.08");
		commentList1.setUserName("안재휘");
		
		CommentReply commentList2 = new CommentReply();
		commentList2.setContent("댓글 더미데이터입니다");
		commentList2.setDate("2024.11.08");
		commentList2.setUserName("안재휘");
		
		CommentReply commentList3 = new CommentReply();
		commentList3.setContent("댓글 더미데이터입니다");
		commentList3.setDate("2024.11.08");
		commentList3.setUserName("안재휘");
		
		list.add(commentList1);
		list.add(commentList2);
		list.add(commentList3);
		
		return new Gson().toJson(list); //list를 JSON(문자열)으로 변환해서 리턴 
	}
	
	//댓글 수정
	@PostMapping("updateReply.bo")
	public String updateReply() {
		System.out.println("update댓글 컨트롤러 실행");
		return "redirect: /community/boardDetail";
	}
	
	//신고요청
	@PostMapping("report.bo")
	public String insertReport() {
		
		System.out.println("신고컨트롤러에서 받음");
		return "community/boardDetail"; // 임시로 설정
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