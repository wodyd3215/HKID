package com.kh.hkid.challenge.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kh.hkid.admin.model.vo.Notice;
import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.challenge.model.vo.ChallengeBoard;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.Community;

public interface ChallengeService {
	
	//챌린지 총 갯수 가져오기
	int boardCount();
	
	//챌린지리스트 목록 가져오기
	ArrayList<Challenge> selectList(PageInfo pi);

	//챌린지 보드 총 갯수 가져오기
	int challengeBoardCount(int cno);

	//챌린지보드리스트 목록 가져옥;
	ArrayList<ChallengeBoard> chBoardselectList(int cno, PageInfo pi);

	//챌린지 이름 가져오는 용도
	Challenge selectName(int cno);

	//검색된 보드 갯수
	int selectSearchCount(HashMap<String, Object> map);

	//검샏된 보드 리스트
	ArrayList<ChallengeBoard> selectSearchList(HashMap<String, Object> map, PageInfo pi);

	//보드 디테일
	ChallengeBoard selectBoard(int cbno);

	//게시글 추가
	int insertBoard(ChallengeBoard c);

	//공지 조회
	ArrayList<Notice> selectNoticeList(PageInfo pi);

	//게시글 수정
	int updateBoard(ChallengeBoard c);

	//게시글 삭제
	int deleteboard(int cbno);

	//cno 가져오기
	ChallengeBoard selectCno(int cbno);

	



}
