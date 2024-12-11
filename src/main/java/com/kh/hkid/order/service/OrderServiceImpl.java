package com.kh.hkid.order.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.hkid.order.model.dao.OrderDao;
import com.kh.hkid.order.model.vo.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private OrderDao orderDao;
	
	@Override
	public Order insertPurchaseInfo(Order o) {
		int result = orderDao.insertPurchaseInfo(sqlSession, o);
		
		Order order = null;
		if(result > 0) {
			order = orderDao.selectPurchaseInfo(sqlSession, o);
		} else {
			return null;
		}
		return order;
	}

}
