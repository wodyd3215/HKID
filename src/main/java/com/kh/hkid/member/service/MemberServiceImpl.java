package com.kh.hkid.member.service;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.hkid.chatting.model.vo.Message;
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

	// 회원 정보 변경(비밀번호 X)
	@Transactional
	@Override
	public int updateMember(Member m) {
		return memberDao.updateMember(sqlSession, m);
	}

	@Transactional
	@Override
	public int updatePwd(Member m) {
		return memberDao.updatePwd(sqlSession, m);
	}
	
	// 회원 삭제
	@Transactional
	@Override
	public int deleteMember(String memberId) {
		return memberDao.deleteMember(sqlSession, memberId);
	}

	// 회원 아이디 찾기
	@Override
	public String searchId(String email) {
		return memberDao.searchId(sqlSession, email);
	}

	// 비밀번호 찾기
	@Override
	public int searchPwd(Member m) {
		return memberDao.searchPwd(sqlSession, m);
	}

	// 비밀번호 수정(로그인 x)
	@Transactional
	@Override
	public int changePwd(Member m) {
		return memberDao.changePwd(sqlSession, m);
	}
	
	@Transactional
	@Override
	public int imgChangeAjax(Member m) {
		return memberDao.imgChangeAjax(sqlSession, m);
	}

	// 회원 유무 판단
	@Override
	public int searchMember(Member m) {
		return memberDao.searchMember(sqlSession, m);
	}
	
	// 소셜로그인
	@Override
	public Member socialLoginMember(Member m) {
		return memberDao.socialLoginMember(sqlSession, m);
	}

	// 소셜 회원가입
	@Transactional
	@Override
	public int insertSocialMember(Member m) {
		return memberDao.insertSocialMember(sqlSession, m);
	}

	// 유저 닉네임 조회
	@Override
	public ArrayList<Member> searchNickName(String nickName) {
		return memberDao.searchNickName(sqlSession, nickName);
	}
	
	// 발신자 정보
	@Override
	public Member senderInfo(Message m) {
		return memberDao.senderInfo(sqlSession, m);
	}

	// 계정 복구 신청
	@Override
	public int recoveryApply(int memberNo) {
		return memberDao.recoveryApply(sqlSession, memberNo);
	}

	@Override
	public int emailCheck(String email) {
		return memberDao.emailCheck(sqlSession, email);
	}
}
