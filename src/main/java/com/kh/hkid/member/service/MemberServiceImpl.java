package com.kh.hkid.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.hkid.member.model.dao.MemberDao;
import com.kh.hkid.member.model.vo.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MemberDao memberDao;
	
	// 회원가입
	@Transactional
	@Override
	public int insertMember(Member m) {
		return memberDao.insertMember(sqlSession, m);
	}
}
