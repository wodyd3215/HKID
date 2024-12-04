package com.kh.hkid.challenge.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.challenge.model.dao.ChallengeDao;
import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.exercise.model.dao.ExerciseDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ChallengeServiceImple implements ChallengeService {

	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final ChallengeDao challengeDao;
	
	@Override
	public int boardCount() {
		return challengeDao.boardCount(sqlSession);
	}

	@Override
	public ArrayList<Challenge> selectList(PageInfo pi) {
		return challengeDao.selectList(sqlSession, pi);
	}

	@Override
	public int challengeBoardCount() {
		return challengeDao.challengeBoardCount(sqlSession);
	}

	@Override
	public ArrayList<Challenge> chBoardselectList(int cno, PageInfo pi) {
		return challengeDao.challengeBoardList(sqlSession, pi, cno);
	}

	@Override
	public List<Challenge> selectChallenge(int cno) {
		return challengeDao.selectChallenge(sqlSession, cno);
	}


}
