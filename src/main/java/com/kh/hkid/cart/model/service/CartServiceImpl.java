package com.kh.hkid.cart.model.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.cart.model.dao.CartDao;
import com.kh.hkid.cart.model.vo.Cart;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final CartDao cartDao;

	@Override
	public ArrayList<Cart> selectCart(int memberNo) {
		return cartDao.selectCart(sqlSession, memberNo);
	}

	@Override
	public int changeQuantity(Cart c) {
		return cartDao.changeQuantity(sqlSession, c);
	}

	@Override
	public int deleteOne(Cart c) {
		return cartDao.deleteOne(sqlSession, c);
	}

	

	

}
