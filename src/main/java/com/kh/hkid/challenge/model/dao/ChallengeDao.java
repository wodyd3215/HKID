package com.kh.hkid.challenge.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.challenge.model.vo.Challenge;
import com.kh.hkid.challenge.model.vo.ChallengeBoard;
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
	public int challengeBoardCount(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("challengeMapper.challengeBoardCount", cno);
	}

	//챌린지 보드 페이지 정보
	public ArrayList<ChallengeBoard> challengeBoardList(SqlSessionTemplate sqlSession, int cno, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList) sqlSession.selectList("challengeMapper.challengeSelect", cno, rowBounds);
	}

	public Challenge selectName(SqlSessionTemplate sqlSession, int cno) {
		return sqlSession.selectOne("challengeMapper.selectName", cno);
	}

	public int selectSearchCount(SqlSessionTemplate sqlSession, HashMap<String, Object> param) {
		return sqlSession.selectOne("challengeMapper.selectSearchCount", param);
	}

	public ArrayList<ChallengeBoard> chBoardselectList(SqlSessionTemplate sqlSession, HashMap<String, Object> param, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList) sqlSession.selectList("challengeMapper.chBoardselectList", param, rowBounds);
	}

}
