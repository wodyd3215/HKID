package com.kh.hkid.phase.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.phase.model.vo.Phase;

@Repository
public class PhaseDao {

	public ArrayList<Phase> selectList(SqlSessionTemplate sqlSession, HashMap<String, Object> order1) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("phaseMapper", order1);
	}

	

}
