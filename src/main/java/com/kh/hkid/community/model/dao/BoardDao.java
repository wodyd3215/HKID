package com.kh.hkid.community.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.community.model.vo.Board;

@Repository
public class BoardDao {
	
	// 게시글 개수
	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}
	
	//게시글 목록
	public ArrayList<Board> selectList(SqlSessionTemplate sqlSession){
		return (ArrayList)sqlSession.selectList("boardMapper.selectList");
		
	}
 
	
	
}
