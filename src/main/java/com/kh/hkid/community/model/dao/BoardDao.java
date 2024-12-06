package com.kh.hkid.community.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dto.CommentReply;
import com.kh.hkid.community.model.dto.Community;
import com.kh.hkid.community.model.vo.Board;
import com.kh.hkid.community.model.vo.Reply;

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
	
	//조회수 증가
	public int increaseView(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.increaseView", boardNo);
	}
	
	//게시글 삭제
	public int deleteboard(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.update("boardMapper.deleteboard", boardNo);
	}
	
	//신고당한 사람
	public int selectReportedUserNo(SqlSessionTemplate sqlSession, int boardNo) {
		return sqlSession.selectOne("boardMapper.selectReportedUserNo", boardNo);
	}
	
	//신고
	public int insertReport(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.insert("boardMapper.insertReport", map);
	}
	
	//게시글 추가
	public int insertBoard(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.insert("boardMapper.insertBoard", b);
	}
	
	//게시글 추가(파일)
	public int insertBoardFile(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.insert("boardMapper.insertBoardFile", b);
	}
	
	//게시글 수정
	public int updateBoard(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("boardMapper.updateBoard", b);
	}
	
	//게시글 수정(파일)
	public int updateBoardFile(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("boardMapper.updateBoardFile", b);
	}
	
	//좋아요 유무체크
	public int checkGood(SqlSessionTemplate sqlSession, HashMap<String, Integer> map) {
		return sqlSession.selectOne("boardMapper.checkGood", map);
	}
	
	//좋아요 상태 체크
	public char checkGoodStatus(SqlSessionTemplate sqlSession, HashMap<String, Integer> map) {
		String result = sqlSession.selectOne("boardMapper.checkGoodStatus", map);
		
		if (result != null && !result.isEmpty()) {
	        return result.charAt(0); //char로 형변환
	    } else {
	        throw new IllegalStateException("쿼리 결과가 null이거나 비어 있습니다.");
	    }
	}
	
	//좋아요 생성
	public int insertGood(SqlSessionTemplate sqlSession, HashMap<String, Integer> map) {
		return sqlSession.insert("boardMapper.insertGood", map);
	}
	
	//좋아요 수정
	public int updateGood(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.insert("boardMapper.updateGood", map);
	}
	
	//좋아요 개수
	public int countGood(SqlSessionTemplate sqlSession,int boardNo) {
		return sqlSession.selectOne("boardMapper.countGood", boardNo);
	}
	
	//댓글 목록
	public ArrayList<CommentReply> selectReplyList(SqlSessionTemplate sqlSession, int boardNo) {
		return (ArrayList)sqlSession.selectList("boardMapper.selectReplyList", boardNo);
	}
	
	//댓글 추가 
	public int insertReply(SqlSessionTemplate sqlSession, Reply r) {
		return sqlSession.insert("boardMapper.insertReply", r);
	}
	
	//댓글 삭제
	public int deleteReply(SqlSessionTemplate sqlSession, HashMap<String, Integer> map) {
		return sqlSession.delete("boardMapper.deleteReply", map);
	}
	
	//댓글 수정
	public int updateReply(SqlSessionTemplate sqlSession, Reply r) {
		return sqlSession.update("boardMapper.updateReply", r);
	}
	
	
	
	
}
