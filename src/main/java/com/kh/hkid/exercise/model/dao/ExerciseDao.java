package com.kh.hkid.exercise.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.exercise.model.vo.Exercise;

@Repository
public class ExerciseDao {
	
	//운동리스트
	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("exerciseMapper.selectListCount");
	}
	
	//운동리스트 페이징 처리
	public ArrayList<Exercise> selectList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList) sqlSession.selectList("exerciseMapper.selectList", null, rowBounds);
	}
	
	//필터링 검색 
	public List<Exercise> search(SqlSessionTemplate sqlSession, HashMap<String, Object> filterMap) {
		return sqlSession.selectList("exerciseMapper.exerciseSearch", filterMap);

	}

}
