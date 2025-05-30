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

	//필터
	@Override
	public List<Exercise> search(HashMap<String, Object> filterMap, PageInfo pi) {
		return exerciseDao.search(sqlSession, filterMap, pi);
	}
	
	
	// exerciseNo로 운동 조회
	@Override
	public Exercise selectExercise(int eno) {
		return exerciseDao.selectExercise(sqlSession, eno);
	}

	//검색된 운동 갯수
	@Override
	public int searchListCount(HashMap<String, Object> filterMap) {
		return exerciseDao.selectListCount(sqlSession, filterMap);
	}
	
	
	
	
}
