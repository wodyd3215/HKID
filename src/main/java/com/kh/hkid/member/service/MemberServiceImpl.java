package com.kh.hkid.member.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.hkid.diary.model.vo.Diary;
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
	@Transactional // 트랜잭션 관리를 해주는 어노테이션
	@Override
	public int insertMember(Member m) {
		return memberDao.insertMember(sqlSession, m);
	}

	// 로그인
	@Override
	public Member loginMember(Member m) {
		return memberDao.loginMember(sqlSession, m);
	}
	
	// 아이디 중복체크
	@Override
	public int idCheck(String checkId) {
		return memberDao.idCheck(sqlSession, checkId);
	}
	
	// 닉네임 중복체크
	@Override
	public int nickCheck(String checkNick) {
		return memberDao.nickCheck(sqlSession, checkNick);
	}

	// 회원 정보 수정(이메일, 전화번호, 비밀번호, 주소)
	@Transactional
	@Override
	public int updateEmail(Member m) {
		return memberDao.updateEmail(sqlSession, m);
	}

	@Transactional
	@Override
	public int updatePhone(Member m) {
		return memberDao.updatePhone(sqlSession, m);
	}
	
	@Transactional
	@Override
	public int updatePwd(Member m) {
		return memberDao.updatePwd(sqlSession, m);
	}

	@Transactional
	@Override
	public int updateAddress(Member m) {
		return memberDao.updateAddress(sqlSession, m);
	}

	// 회원 삭제
	@Transactional
	@Override
	public int deleteMember(String memberId) {
		return memberDao.deleteMember(sqlSession, memberId);
	}

}
