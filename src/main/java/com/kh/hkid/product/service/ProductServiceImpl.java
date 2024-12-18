package com.kh.hkid.product.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.product.model.dao.ProductDao;
import com.kh.hkid.product.model.vo.Product;
import com.kh.hkid.product.model.vo.Review;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final ProductDao productDao;

	@Override
	public int selectListTotal(String category) {
		return productDao.selectListTotal(sqlSession, category);
	}

	@Override
	public ArrayList<Product> selectList(PageInfo pi, String category) {
		return productDao.selectList(sqlSession, pi, category);
	}

	@Override
	public Product selectProduct(int productNo) {
		return productDao.selectProduct(sqlSession, productNo);
	}

	@Override
	public ArrayList<Product> ajaxSelectedNav(String selectedValue) {
		return productDao.chooseNav(sqlSession, selectedValue);
	}

	@Override
	public ArrayList<Product> ajaxTabBtn(String rbtn) {
		return productDao.selectRbtn(sqlSession, rbtn);
	}

	
//	@Override
//	public int selectProductCategoryListCount(String category) {
//		return productDao.selectProductCategoryListCount(sqlSession, category);
//	}
//
//	@Override
//	public ArrayList<Product> selectProductCategoryList(PageInfo pi, String category) {
//		return productDao.selectProductCategoryList(sqlSession, pi, category);
//	}

	@Override
	public ArrayList<Product> searchList(HashMap<String, String> map, PageInfo pi) {
		return productDao.searchList(sqlSession, map, pi);
	}

	@Override
	public int selectSearchCount(HashMap<String, String> map) {
		return productDao.selectSearchCount(sqlSession, map);
	}

	@Override
	public ArrayList<Product> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		return productDao.selectSearchList(sqlSession, map, pi);
	}
	
		public int reviewCount(int productNo) {
		return productDao.reviewCount(sqlSession, productNo);
	}

	@Override
	public ArrayList<Review> selectReviewList(PageInfo pi, int productNo) {
		return productDao.selectReviewList(sqlSession, pi, productNo);
	}

}
