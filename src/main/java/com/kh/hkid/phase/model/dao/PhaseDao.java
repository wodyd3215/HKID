package com.kh.hkid.phase.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.phase.model.vo.Phase;
import com.kh.hkid.product.model.vo.Review;

@Repository
public class PhaseDao {

	public ArrayList<Phase> selectList(SqlSessionTemplate sqlSession, HashMap<String, Object> order1) {
		// TODO Auto-generated method stub
		return (ArrayList)sqlSession.selectList("phaseMapper", order1);
	}

	public int insertPhase(SqlSessionTemplate sqlSession, Phase p) {
		return sqlSession.insert("phaseMapper", p);
	}

	

	

}
