package com.kh.hkid.challenge.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.admin.model.vo.Notice;
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

	//검색된 보드 총 갯수
	public int selectSearchCount(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
	      return sqlSession.selectOne("challengeMapper.selectSearchCount", map);
	   }

	   //검색 게시글 목록
	   public ArrayList<ChallengeBoard> selectSearchList(SqlSessionTemplate sqlSession, HashMap<String, Object> map, PageInfo pi) {
	      int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
	      int limit = pi.getBoardLimit();
	      RowBounds rowBounds = new RowBounds(offset, limit);
	      
	      return (ArrayList)sqlSession.selectList("challengeMapper.selectSearchList", map, rowBounds);
	   }

	// 게시글 상세 조회
	public ChallengeBoard selectBoard(SqlSessionTemplate sqlSession, int cbno) {
		return sqlSession.selectOne("challengeMapper.selectBoard", cbno);
	}

	//게시글 추가
	public int insertBoard(SqlSessionTemplate sqlSession, ChallengeBoard c) {
		return sqlSession.insert("challengeMapper.insertBoard", c);
	}
	
	//게시글 추가(파일)
	public int insertBoardFile(SqlSessionTemplate sqlSession, ChallengeBoard c) {
		return sqlSession.insert("challengeMapper.insertBoardFile", c);
	}

	public ArrayList<Notice> selectNoticeList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
	    int limit = pi.getBoardLimit();
	    RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList) sqlSession.selectList("challengeMapper.selectNoticeList", rowBounds);
	}

	//조회수
	public int increaseView(SqlSessionTemplate sqlSession, int cbno) {
		return sqlSession.update("challengeMapper.increaseView", cbno);	
	}

	//게시글 수정
	public int updateBoard(SqlSessionTemplate sqlSession, ChallengeBoard c) {
		return sqlSession.update("challengeMapper.updateBoard", c);
	}

	//게시글 수정(파일)
	public int updateBoardFile(SqlSessionTemplate sqlSession, ChallengeBoard c) {
		return sqlSession.update("challengeMapper.updateBoardFile", c);
	}

}
