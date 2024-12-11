package com.kh.hkid.favorite.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.favorite.model.dao.FavoriteDao;
import com.kh.hkid.favorite.model.vo.Favorite;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FavoriteImpl implements FavoriteService{
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final FavoriteDao favoriteDao;

	@Override
	public ArrayList<Favorite> selectList(int memberNo, PageInfo pi) {
		return favoriteDao.selectList(sqlSession, memberNo, pi);
	}

	@Override
	public int selectListCount(int memberNo) {
		return favoriteDao.selectCount(sqlSession, memberNo);
	}
	


}
