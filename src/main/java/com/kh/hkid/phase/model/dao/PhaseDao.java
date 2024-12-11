package com.kh.hkid.phase.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.phase.model.vo.Phase;
import com.kh.hkid.product.model.vo.Review;

@Repository
public class PhaseDao {

	public ArrayList<Phase> selectList(SqlSessionTemplate sqlSession, Phase p) {
		return (ArrayList)sqlSession.selectList("phaseMapper.selectList", p);
	}

	public int insertPhase(SqlSessionTemplate sqlSession, Phase p) {
		return sqlSession.insert("phaseMapper.insertPhase", p);
	}

	public int insertReview(SqlSessionTemplate sqlSession, Review r) {
		return sqlSession.insert("phaseMapper.insertReview", r);
	}

	public Review selectReview(SqlSessionTemplate sqlSession, Review r) {
		return sqlSession.selectOne("phaseMapper.selelctReview", r);
	}

	public int selectCount(SqlSessionTemplate sqlSession, int memberNo) {		
		return sqlSession.selectOne("phaseMapper.selectCount", memberNo);
	}

	public ArrayList<Phase> phaseList(SqlSessionTemplate sqlSession, int memberNo, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("phaseMapper.phaseList", memberNo, rowBounds);
	}	

}
