package com.kh.hkid.product.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.product.model.vo.Product;
import com.kh.hkid.product.model.vo.Review;

public interface ProductService {

	// 상품 페이지 모두 불러오기
	int selectListTotal();

	// 상품 페이지 목록 불러오기 
	ArrayList<Product> selectList(PageInfo pi);
	
	// 카테고리별 상품 페이지 갯수
	int selectProductCategoryListCount(String category);
	
	// 카테고리별 상품 페이지 리스트
	ArrayList<Product> selectProductCategoryList(PageInfo pi, String category);
	
	// productNo로 상품 목록 조회
	Product selectProduct(int productNo);

	// ajax 를 활용하여 왼쪽 사이드바에 의해 리스트 정렬
	ArrayList<Product> ajaxSelectedNav(String selectedValue);

	// ajax 를 활용하여 상품/중고 페이지 이동
	ArrayList<Product> ajaxTabBtn(String rbtn);

	// 검색 바
	ArrayList<Product> searchList(HashMap<String, String> map, PageInfo pi);

	//검색한 게시글의 개수
	int selectSearchCount(HashMap<String, String> map);
	
	//검색한 게시글 목록
	ArrayList<Product> selectSearchList(HashMap<String, String> map, PageInfo pi);
	int reviewCount(int productNo);
	
	ArrayList<Review> selectReviewList(PageInfo pi, int productNo);

	

}
