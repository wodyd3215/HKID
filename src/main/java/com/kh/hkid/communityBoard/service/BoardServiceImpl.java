package com.kh.hkid.communityBoard.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private final SqlSessionTemplate sqlsession;
	
//	@Autowired
//	private final BoardDao boardDao;
	
	

	
}
