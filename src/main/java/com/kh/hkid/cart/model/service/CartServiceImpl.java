package com.kh.hkid.cart.model.service;

import java.util.ArrayList;
import java.util.HashMap;

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
	public int changeQuantity(HashMap<Object, Integer> map) {
		return cartDao.changeQuantity(sqlSession, map);
	}

	@Override
	public int deleteCart(String[] pick) {
		return cartDao.deleteCart(sqlSession, pick);
	}

	@Override
	public int addCart(Cart c) {
		return cartDao.addCart(sqlSession, c);
	}

	@Override
	public int deleteCart(HashMap<Object, Integer> de) {
		return cartDao.deleteCart(sqlSession, de);
	}


}
