package com.kh.hkid.diet.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.diet.model.vo.Diet;

@Repository
public class DietDao {
	
	// 영양정보 저장
	public int saveDietInfo(SqlSessionTemplate sqlSession, Diet d) {
		return sqlSession.insert("dietMapper.saveDietInfo", d);
	}
}
