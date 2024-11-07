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
	
	//�Խñ� ���
	@GetMapping("list.bo")
	public String selectList() {
		
		return "community/boardList";
	}
	
	//�Խñ� �ۼ�
	@GetMapping("boardWrite.bo")
	public String boardWrite() {
		
		return "community/boardWrite";
	}
	
	//�Խñ� ������
	@GetMapping("boardDetail.bo")
	public String selectDetailBoard() {
		
		return "community/boardDetail";
	}
	
	//�Խñ� ����
	@PostMapping("updateForm.bo")
	public String updateForm() {
		System.out.println("updateForm.bo���� ����");
		return "community/boardDetail"; //�ӽ÷� ����
	}
	
	//�Խñ� ����
	@PostMapping("boardDelete.bo")
	public String boardDelete() {
		System.out.println("������Ʈ�ѷ����� ����");
		return "community/boardDetail"; // �ӽ÷� ����
	}
	
	//��� �߰�
	@ResponseBody
	@PostMapping("insertReply.bo")
	public String insertReply(){
		
		return "null";
	}
	
	//ajax ��۸�� select
	@ResponseBody
	@PostMapping(value="replyList.bo", produces = "application/json; charset = UTF-8") //produces="Ÿ��/����Ÿ��"
	public String ajaxSelectReplyList(int bno) {
		//DB���� ��� ����
//		ArrayList<Reply> list = boardService.ajaxSelectReplyList(bno); 
		
		//DB ���� �������� ���!!
		Reply list = new Reply();
		
		return new Gson().toJson(list); //list�� JSON(���ڿ�)���� ��ȯ�ؼ� ���� 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 //-------------------------summernote----------------------------
	
	//ajax�� ���� ���ε�
	//���ϸ���� �����ϰ� ����� ���ϸ� ��ϸ��� ��ȯ
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
		//���� ������
		String originName = upfile.getOriginalFilename();
		
		//Ȯ����
		String ext = originName.substring(originName.lastIndexOf("."));
		
		//����ú���
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		//5�ڸ� ������
		int randNum = (int)(Math.random()*90000) + 10000;
		String changeName = currentTime + "_" + randNum + ext;
		
		//÷������ ������ ������ ������ ���
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
