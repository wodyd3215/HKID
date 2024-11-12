package com.kh.hkid.community.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.community.model.dao.BoardDao;
import com.kh.hkid.community.model.vo.Board;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final BoardDao boardDao;

	
	@Override
	public int selectListCount() {
		return boardDao.selectListCount(sqlSession);
	}
	
	@Override
	public ArrayList<Board> selectList() {
		return boardDao.selectList(sqlSession);
	}

	
	
//	@Autowired
//	private final BoardDao boardDao;
	
	

	
}
