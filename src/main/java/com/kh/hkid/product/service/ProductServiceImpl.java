package com.kh.hkid.product.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.product.model.dao.ProductDao;
import com.kh.hkid.product.model.vo.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ProductDao productDao;

	@Override
	public int selectListTotal() {
		return productDao.selectListCount(sqlSession);
	}

	@Override
	public ArrayList<Product> selectList(PageInfo pi) {
		return productDao.selectList(sqlSession, pi);
	}

	@Override
	public ArrayList<Product> selectSideItem(Product p) {
		return productDao.selectSideItem(sqlSession, p);
	}
}
