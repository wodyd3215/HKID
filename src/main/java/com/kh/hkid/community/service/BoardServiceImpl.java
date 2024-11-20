package com.kh.hkid.community.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.community.model.dao.BoardDao;
import com.kh.hkid.community.model.dto.Community;
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

	@Override
	public ArrayList<Community> selectNoticeList() {
		
		return boardDao.selectNoticeList(sqlSession);
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		return boardDao.selectSearchCount(sqlSession, map);
	}

	@Override
	public ArrayList<Community> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		return boardDao.selectSearchList(sqlSession, map, pi);
	}

	@Override
	public Board selectBoard(int bno) {
		return boardDao.selectBoard(sqlSession, bno); //해당 게시글 가져오기;
	}

	@Override
	public int deleteboard(int bno) {
		return boardDao.deleteboard(sqlSession, bno);
	}

	@Override
	public int insertReport(int bno) {
		return boardDao.insertReport(sqlSession, bno);
	}
	

	
}
