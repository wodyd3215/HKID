package com.kh.hkid.cart.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.cart.model.vo.Cart;

@Repository
public class CartDao {

	public ArrayList<Cart> selectCart(SqlSessionTemplate sqlSession, String memberNo) {
		return (ArrayList)sqlSession.selectList("cartMapper.selectCart", memberNo);
	}

	public int changeQuantity(SqlSessionTemplate sqlSession, Cart c) {
		return sqlSession.update("cartMapper.changeQuantity", c);
	}

	public int deleteOne(SqlSessionTemplate sqlSession, Cart c) {		
		return sqlSession.delete("cartMapper.deleteCart", c);
	}

	
	
	
}
