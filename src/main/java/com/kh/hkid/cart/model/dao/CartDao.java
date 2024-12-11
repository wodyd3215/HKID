package com.kh.hkid.cart.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.cart.model.vo.Cart;

@Repository
public class CartDao {

	public ArrayList<Cart> selectCart(SqlSessionTemplate sqlSession, int memberNo) {
		return (ArrayList)sqlSession.selectList("cartMapper.selectCart", memberNo);
	}

	public int changeQuantity(SqlSessionTemplate sqlSession, HashMap<Object, Integer> map) {
		return sqlSession.update("cartMapper.changeQuantity", map);
	}

	public int addCart(SqlSessionTemplate sqlSession, Cart c) {
		return sqlSession.insert("carMapper.insertCart", c);
	}

	public int deleteCart(SqlSessionTemplate sqlSession, Cart c) {
		return sqlSession.delete("cartMapper.deleteCart", c);		
	}

	public int deleteCarts(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		return sqlSession.delete("cartMapper.deleteCarts",map);
	}

	
	
	
}
