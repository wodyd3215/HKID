package com.kh.hkid.communityBoard.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.hkid.community.model.vo.Reply;
import com.kh.hkid.communityBoard.service.BoardService;

@Controller
public class BoardController {

	private final BoardService boardService;

	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	//게시글 목록
	@GetMapping("list.bo")
	public String selectList() {
		
		return "community/boardList";
	}
	
	//게시글 작성
	@GetMapping("boardWrite.bo")
	public String boardWrite() {
		
		return "community/boardWrite";
	}
	
	//게시글 디테일
	@GetMapping("boardDetail.bo")
	public String selectDetailBoard() {
		
		return "community/boardDetail";
	}
	
	//게시글 수정
	@PostMapping("updateForm.bo")
	public String updateForm() {
		System.out.println("updateForm.bo에서 받음");
		return "community/boardDetail"; //임시로 설정
	}
	
	//게시글 삭제
	@PostMapping("boardDelete.bo")
	public String boardDelete() {
		System.out.println("삭제컨트롤러에서 받음");
		return "community/boardDetail"; // 임시로 설정
	}
	
	//댓글 추가
	@ResponseBody
	@PostMapping("insertReply.bo")
	public String insertReply(){
		
		return "null";
	}
	
	//ajax 댓글목록 select
	@ResponseBody
	@PostMapping(value="replyList.bo", produces = "application/json; charset = UTF-8") //produces="타입/서브타입"
	public String ajaxSelectReplyList(int bno) {
		//DB들어가면 사용 ㄱㄱ
//		ArrayList<Reply> list = boardService.ajaxSelectReplyList(bno); 
		
		//DB 들어가기 전까지만 사용!!
		Reply list = new Reply();
		
		return new Gson().toJson(list); //list를 JSON(문자열)으로 변환해서 리턴 
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
