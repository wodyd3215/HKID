package com.kh.hkid.challenge.service;

import java.util.ArrayList;

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

}
