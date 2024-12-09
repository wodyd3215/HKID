package com.kh.hkid.favorite.model.dao;
      
import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.favorite.model.vo.Favorite;

@Repository
public class FavoriteDao {

	public ArrayList<Favorite> selectList(SqlSessionTemplate sqlSession, int memberNo, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("favoriteMapper.selectList", memberNo, rowBounds);
	}

	public int selectCount(SqlSessionTemplate sqlSession, int memberNo) {
		return sqlSession.selectOne("favoriteMapper.selectCount", memberNo);
	}

	
}
