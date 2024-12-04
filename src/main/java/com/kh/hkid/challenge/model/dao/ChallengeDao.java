package com.kh.hkid.challenge.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.common.vo.PageInfo;

@Repository
public class ChallengeDao {
	// 챌린지 총 갯수
	public int boardCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("challengeMapper.boardCount");
	}
	
	//챌린지 페이지 정보
	public ArrayList<Challenge> selectList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);

		return (ArrayList) sqlSession.selectList("challengeMapper.selectList", null, rowBounds);
	}

	
	//CHE_RES_NO로 CHELLANGE_NO갯수
	public int challengeBoardCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("challengeMapper.challengeBoardCount");
	}

	//챌린지 보드 페이지 정보
	public ArrayList<Challenge> challengeBoardList(SqlSessionTemplate sqlSession, PageInfo pi, int cno) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList) sqlSession.selectList("challengeMapper.challengeSelect", null, rowBounds);
	}

	public List<Challenge> selectChallenge(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectList("challengeMapper.selectChallenge", cno);
	}

}
