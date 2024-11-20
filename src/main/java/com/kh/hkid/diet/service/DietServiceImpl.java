package com.kh.hkid.diet.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.hkid.diet.model.dao.DietDao;
import com.kh.hkid.diet.model.vo.Diet;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DietServiceImpl implements DietService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private DietDao dietDao;
	
	// 영양정보 저장
	@Transactional
	@Override
	public int saveDietInfo(Diet d) {
		return dietDao.saveDietInfo(sqlSession, d);
	}

	@Override
	public Diet loadDietAjax(int memberNo) {
		return dietDao.loadDietAjax(sqlSession, memberNo);
	}

}
