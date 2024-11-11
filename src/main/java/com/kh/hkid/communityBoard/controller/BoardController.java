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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.kh.hkid.community.model.dto.CommentReply;
import com.kh.hkid.community.model.vo.Reply;
import com.kh.hkid.communityBoard.service.BoardService;

@Controller
public class BoardController {

	private final BoardService boardService;
	

	@Autowired
	public BoardController(BoardService boardService) {
		super();
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
	public String selectDetailBoard(Model model) {
		
		//DB ���� �������� ���!!
		ArrayList<CommentReply> replyList = new ArrayList<>();
		CommentReply commentReply = new CommentReply();
		
		commentReply.setContent("��� ���̵������Դϴ�");
		commentReply.setDate("2024.11.08");
		commentReply.setUserName("������");
		
		replyList.add(commentReply)	;	
		int replyCount = replyList.size();
		
		model.addAttribute("replyList", replyList);
		model.addAttribute("replyCount", replyCount);
		
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
	
	//����߰�
	@ResponseBody
	@RequestMapping("insertReply.bo")
//	@PostMapping(value="insertReply.bo", produces="application/json; charset-UTF-8")
	public String ajaxInsertReply(Reply r) {
	    // ó�� �� JSON ������ ���� ��ȯ
	    return "success";
	}
	
	//ó�� ��� ��� ���
	
	
	//ajax ��۸�� select
	@ResponseBody
	@GetMapping(value="replyList.bo", produces = "application/json; charset = UTF-8") //produces="Ÿ��/����Ÿ��"
	public String ajaxSelectReplyList(int bno) {
		//DB���� ��� ����
		ArrayList<CommentReply> list = new ArrayList<>();
		
		//DB ���� �������� ���!!
		CommentReply commentList1 = new CommentReply();
		commentList1.setContent("��� ���̵������Դϴ�");
		commentList1.setDate("2024.11.08");
		commentList1.setUserName("������");
		
		CommentReply commentList2 = new CommentReply();
		commentList2.setContent("��� ���̵������Դϴ�");
		commentList2.setDate("2024.11.08");
		commentList2.setUserName("������");
		
		CommentReply commentList3 = new CommentReply();
		commentList3.setContent("��� ���̵������Դϴ�");
		commentList3.setDate("2024.11.08");
		commentList3.setUserName("������");
		
		list.add(commentList1);
		list.add(commentList2);
		list.add(commentList3);
		
		return new Gson().toJson(list); //list�� JSON(���ڿ�)���� ��ȯ�ؼ� ���� 
	}
	
	//��� ����
	@PostMapping("updateReply.bo")
	public String updateReply() {
		System.out.println("update��� ��Ʈ�ѷ� ����");
		return "redirect: /community/boardDetail";
	}
	
	//�Ű��û
	@PostMapping("report.bo")
	public String insertReport() {
		
		System.out.println("�Ű���Ʈ�ѷ����� ����");
		return "community/boardDetail"; // �ӽ÷� ����
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
