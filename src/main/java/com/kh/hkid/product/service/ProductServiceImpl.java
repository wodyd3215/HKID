package com.kh.hkid.product.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.product.model.dao.ProductDao;
import com.kh.hkid.product.model.vo.Product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private final SqlSessionTemplate sqlSession;
	
	@Autowired
	private final ProductDao productDao;

	@Override
	public int selectListTotal() {
		return productDao.selectListTotal(sqlSession);
	}

	@Override
	public ArrayList<Product> selectList(PageInfo pi) {
		return productDao.selectList(sqlSession, pi);
	}

	@Override
	public Product selectProduct(int pno) {
		return productDao.selectProduct(sqlSession, pno);
	}

	@Override
	public ArrayList<Product> ajaxSelectedNav(String selectedValue) {
		return productDao.chooseNav(sqlSession, selectedValue);
	}

	@Override
	public ArrayList<Product> ajaxTabBtn(String rbtn) {
		return productDao.selectRbtn(sqlSession, rbtn);
	}

}
