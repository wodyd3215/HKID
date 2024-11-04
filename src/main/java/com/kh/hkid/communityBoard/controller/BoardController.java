package com.kh.hkid.communityBoard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.hkid.communityBoard.service.BoardService;

@Controller
public class BoardController {

	private final BoardService boardService;

	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	
	@GetMapping("list.bo")
	public String selectList() {
		
		return "community/boardList";
	}
	
	@PostMapping("boardWrite.bo")
	public String boardWrite() {
		
		return "community/boardWrite";
	}
	
	
	@GetMapping("boardDetail.bo")
	public String selectDetailBoard() {
		
		return "community/boardDetail";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
