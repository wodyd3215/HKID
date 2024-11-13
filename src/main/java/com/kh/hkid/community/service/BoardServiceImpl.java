package com.kh.hkid.community.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dao.BoardDao;
import com.kh.hkid.community.model.dto.Community;

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
	public ArrayList<Community> selectList(PageInfo pi) {
		return boardDao.selectList(sqlSession, pi);
	}

	@Override
	public int selectCategoryListCount(String category) {
		return boardDao.selectCategoryListCount(sqlSession, category);
	}

	@Override
	public ArrayList<Community> selectCategoryList(PageInfo pi, String category) {
		return boardDao.selectCategoryList(sqlSession, pi, category);
	}
	
	
	

	
}
