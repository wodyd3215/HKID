package com.kh.hkid.member.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.member.model.vo.Member;

@Repository
public class MemberDao {
	
	// 회원가입
	public int insertMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertMember", m);
	}
	
	// 로그인
	public Member loginMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	public int updateEmail(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateEmail", m);
	}
}
