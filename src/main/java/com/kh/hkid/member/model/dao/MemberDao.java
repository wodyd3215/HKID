package com.kh.hkid.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.diary.model.vo.Diary;
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
	
	// 아이디 중복체크
	public int idCheck(SqlSessionTemplate sqlSession, String checkId) {
		return sqlSession.selectOne("memberMapper.idCheck", checkId);
	}
	
	// 닉네임 중복체크
	public int nickCheck(SqlSessionTemplate sqlSession, String checkNick) {
		return sqlSession.selectOne("memberMapper.nickCheck", checkNick);
	}
	
	// 회원 정보 변경(이메일)
	public int updateEmail(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateEmail", m);
	}
	
	// 회원 정보 변경(전화번호)
	public int updatePhone(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updatePhone", m);
	}
	
	// 회원 정보 변경(비밀번호)
	public int updatePwd(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updatePwd", m);
	}
	
	// 회원 정보 변경(주소)
	public int updateAddress(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateAddress", m);
	}
	
	// 회원 탈퇴
	public int deleteMember(SqlSessionTemplate sqlSession, String memberId) {
		return sqlSession.update("memberMapper.deleteMember", memberId);
	}
	
	// 회원 아이디 찾기
	public String searchId(SqlSessionTemplate sqlSession, String email) {
		return sqlSession.selectOne("memberMapper.searchId", email);
	}
	
	// 비밀번호 찾기
	public int searchPwd(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.searchPwd", m);
	}
}
