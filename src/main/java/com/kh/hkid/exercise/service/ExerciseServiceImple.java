package com.kh.hkid.exercise.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.common.template.Template;
import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.exercise.model.dao.ExerciseDao;
import com.kh.hkid.exercise.model.vo.Exercise;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExerciseServiceImple implements ExerciseService{
	
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final ExerciseDao exerciseDao;
	
	@Override
	public int selectListCount() {
		return exerciseDao.selectListCount(sqlSession);
	}

	@Override
	public ArrayList<Exercise> selectList(PageInfo pi) {
		
		return exerciseDao.selectList(sqlSession, pi);
	}

	@Override
	public List<Exercise> search(HashMap<String, Object> filterMap) {
		return exerciseDao.search(sqlSession, filterMap);
	}
	
	
	
	
}
