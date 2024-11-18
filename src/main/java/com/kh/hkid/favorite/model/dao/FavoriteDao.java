package com.kh.hkid.favorite.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.favorite.model.vo.Favorite;

@Repository
public class FavoriteDao {

	public ArrayList<Favorite> selectList(SqlSessionTemplate sqlSession, int memberNo) {
		return (ArrayList)sqlSession.selectList("favoriteMapper.selectList", memberNo);
	}

	
}
