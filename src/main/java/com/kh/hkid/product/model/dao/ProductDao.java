package com.kh.hkid.product.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.product.model.vo.Product;

@Repository
public class ProductDao {

	public int selectListTotal(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("productMapper.selectListTotal");
	}

	public ArrayList<Product> selectList(SqlSessionTemplate sqlSession, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, limit);
		
		return (ArrayList)sqlSession.selectList("productMapper.selectList", null, rowBounds);
	}

	public Product selectProduct(SqlSessionTemplate sqlSession, int pno) {
		return sqlSession.selectOne("productMapper.selectProduct", pno);
	}
	

	public ArrayList<Product> chooseNav(SqlSessionTemplate sqlSession, String selectedValue) {
		return (ArrayList)sqlSession.selectList("productMapper.choseNav", selectedValue);
	}

	public ArrayList<Product> selectRbtn(SqlSessionTemplate sqlSession, String rbtn) {
		return (ArrayList)sqlSession.selectList("productMapper.Rbtn", rbtn);
	}

	
	
	public int selectProductCategoryListCount(SqlSessionTemplate sqlSession, String category) {
		return sqlSession.selectOne("productMapper.selectProductCategoryListCount", category);
	}

	public ArrayList<Product> selectProductCategoryList(SqlSessionTemplate sqlSession, PageInfo pi, String category) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("productMapper.selectProductCategoryList", category, rowBounds);
	}

	public ArrayList<Product> searchList(SqlSessionTemplate sqlSession, HashMap<String, String> map, PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		int limit = pi.getBoardLimit();
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		return (ArrayList)sqlSession.selectList("productMapper.searchList", map, rowBounds);
	}


	
}
