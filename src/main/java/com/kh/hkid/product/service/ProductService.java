package com.kh.hkid.product.service;

import java.util.ArrayList;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.product.model.vo.Product;

public interface ProductService {

	// 상품 페이지 모두 불러오기
	int selectListTotal();

	// 상품 페이지 목록 불러오기 
	ArrayList<Product> selectList(PageInfo pi);

	// 상품 사이드바 선택한 목록 불러오기
	ArrayList<Product> selectSideItem(Product p);

}
