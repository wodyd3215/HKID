package com.kh.hkid.cart.model.service;

import java.util.ArrayList;

import com.kh.hkid.cart.model.vo.Cart;

public interface CartService {

	// 장바구니 조회
	ArrayList<Cart> selectCart(int memberNo);
	
	// 수량 변경
	int changeQuantity(Cart c);

	// ajax 에서 받은 데이터 삭제
	int deleteOne(Cart c);
	
	

	
	


}
