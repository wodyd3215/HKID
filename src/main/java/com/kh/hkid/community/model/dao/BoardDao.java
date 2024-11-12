package com.kh.hkid.community.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.vo.Board;

@Repository
public class BoardDao {
	
	// 게시글 개수
	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	//게시글 목록
	public ArrayList<Board> selectList(SqlSessionTemplate sqlSession, PageInfo pi){
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		//1,2번째 매개변수는 파라미터, 3번째 자리가 rowBounds의 자리
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
		
	}
 
	
	
}
