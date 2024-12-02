package com.kh.hkid.challenge.service;

import java.util.ArrayList;

import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.common.vo.PageInfo;

public interface ChallengeService {
	
	//챌린지 총 갯수 가져오기
	int boardCount();
	
	//운동리스트 목록 가져오기
	ArrayList<Challenge> selectList(PageInfo pi);

}
