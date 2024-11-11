package com.kh.hkid.product.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.product.model.vo.Product;

@Repository
public class ProductDao {

	public int selectListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("productMapper.selectListCount");
	}

	public ArrayList<Product> selectList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("productMapper.selectList", null, rowBounds);
	}

	public ArrayList<Product> selectSideItem(SqlSessionTemplate sqlSession, Product p) {
		return (ArrayList)sqlSession.selectList("productMapper.selectList",p);
	}

	
}
