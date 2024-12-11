package com.kh.hkid.order.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.order.model.vo.Order;

@Repository
public class OrderDao {
	
	// 구매정보
	public int insertPurchaseInfo(SqlSessionTemplate sqlSession, Order o) {
		return sqlSession.insert("OrderMapper.insertPurchaseInfo", o);
	}
	
	public Order selectPurchaseInfo(SqlSessionTemplate sqlSession, Order o) {
		return sqlSession.selectOne("OrderMapper.selectPurchaseInfo", o);
	}
}
