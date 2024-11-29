package com.kh.hkid.phase.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public ArrayList<Phase> selectList(HashMap<String, Object> order1) {
		return phaseDao.selectList(sqlSession, order1);
	}

	@Override
	public int insertPhase(Phase p) {
		return phaseDao.insertPhase(sqlSession, p);
	}

}
