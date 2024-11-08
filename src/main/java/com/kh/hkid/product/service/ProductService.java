package com.kh.hkid.product.service;

import java.util.ArrayList;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.product.model.vo.Product;

public interface ProductService {

	// 상품 페이지 불러오기
	int selectListCount();

	// 상품 페이지 목록 불러오기 
	ArrayList<Product> selectList(PageInfo pi);

}
