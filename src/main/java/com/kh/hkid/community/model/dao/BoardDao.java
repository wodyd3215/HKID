package com.kh.hkid.community.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.Community;
import com.kh.hkid.community.model.vo.Board;

@Repository
public class BoardDao {
	
	// 게시글 개수
	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	//게시글 목록
	public ArrayList<Community> selectList(SqlSessionTemplate sqlSession, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		//1,2번째 매개변수는 파라미터, 3번째 자리가 rowBounds의 자리
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
	}
	
	//카테고리 게시글 개수
	public int selectCategoryListCount(SqlSessionTemplate sqlSession, String category){
		return sqlSession.selectOne("boardMapper.selectCategoryListCount", category);
	}
	
	//카테고리 게시글 목록
	public ArrayList<Community> selectCategoryList(SqlSessionTemplate sqlSession , PageInfo pi, String category){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectCategoryList", category, rowBounds);
	}
	
	//공지 게시글 목록
	public ArrayList<Community> selectNoticeList(SqlSessionTemplate sqlSession){
		return (ArrayList)sqlSession.selectList("boardMapper.selectNoticeList");
	}
	
	//검색게시글  개수
	public int selectSearchCount(SqlSessionTemplate sqlSession, HashMap<String, String> map){
		return sqlSession.selectOne("boardMapper.selectSearchCount", map);
	}
	
	// 검색게시글  목록
	public ArrayList<Community> selectSearchList(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, rowBounds);
	}
	

	// 게시글 상세 조회
	public Board selectBoard(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", boardNo);
	}
	
	//게시글 삭제
	public int deleteboard(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.deleteboard", boardNo);
	}
	
	//게시글 삭제
	public int insertReport(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.insert("boardMapper.insertReport", boardNo);
	}
	
}
