package com.kh.hkid.challenge.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.common.vo.PageInfo;

@Repository
public class ChallengeDao {

	public int boardCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("challengeMapper.boardCount");
	}

	public ArrayList<Challenge> selectList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList) sqlSession.selectList("challengeMapper.selectList", null, rowBounds);
	}

}
