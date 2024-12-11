package com.kh.hkid.phase.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.phase.model.dao.PhaseDao;
import com.kh.hkid.phase.model.vo.Phase;
import com.kh.hkid.product.model.vo.Review;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PhaseServiceImpl implements PhaseService{
	
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final PhaseDao phaseDao;	

	@Override
	public ArrayList<Phase> selectList(Phase p) {
		return phaseDao.selectList(sqlSession, p);
	}

	@Override
	public int insertPhase(Phase p) {
		return phaseDao.insertPhase(sqlSession, p);
	}

	@Override
	public int addReview(Review r) {
		return phaseDao.insertReview(sqlSession, r);
	}

	@Override
	public String selectDate(Review r) {
		return phaseDao.selectReview(sqlSession, r);
	}

	@Override
	public int selectListCount(int memberNo) {
		return phaseDao.selectCount(sqlSession, memberNo);
	}

	@Override
	public ArrayList<Phase> phaseList(int memberNo, PageInfo pi) {
		return phaseDao.phaseList(sqlSession, memberNo, pi);
	}

	@Override
	public Review selectReview(int memberNo) {
		return null;
	}


}
