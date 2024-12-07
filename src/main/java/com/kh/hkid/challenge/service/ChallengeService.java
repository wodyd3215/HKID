package com.kh.hkid.challenge.service;

import java.util.ArrayList;
import java.util.List;

import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.challenge.model.vo.ChallengeBoard;
import com.kh.hkid.common.vo.PageInfo;

public interface ChallengeService {
	
	//챌린지 총 갯수 가져오기
	int boardCount();
	
	//챌린지리스트 목록 가져오기
	ArrayList<Challenge> selectList(PageInfo pi);

	//챌린지 보드 총 갯수 가져오기
	int challengeBoardCount(int cno);

	//챌린지보드리스트 목록 가져옥;
	ArrayList<ChallengeBoard> chBoardselectList(int cno, PageInfo pi);

	Challenge selectName(int cno);


}
