package com.kh.hkid.cart.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.hkid.cart.model.vo.Cart;

public interface CartService {

	// 장바구니 조회
	ArrayList<Cart> selectCart(int memberNo);
	
	// 수량 변경
	int changeQuantity(HashMap<Object, Integer> map);

	// ajax 에서 받은 데이터 삭제
	int deleteCart(String[] pick);

	// ajax 로 받은 데이터 추가
	int addCart(Cart c);

	// 장바구니 삭제
	int deleteCart(Cart c);
}
