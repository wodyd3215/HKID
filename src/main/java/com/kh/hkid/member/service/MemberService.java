package com.kh.hkid.member.service;

import java.util.ArrayList;

import com.kh.hkid.diary.model.vo.Diary;
import com.kh.hkid.member.model.vo.Member;

public interface MemberService {
	
	// 회원가입
	int insertMember(Member m);
	
	// 로그인
	Member loginMember(Member m);
	
	// 아이디 중복체크
	int idCheck(String checkId);
	
	// 닉네임 중복체크
	int nickCheck(String checkNick);
	
	// 회원 정보 변경(비밀먼호 x)
	int updateMember(Member m);

	// 비밀번호 변경
	int updatePwd(Member m);
	
	// 회원 탈퇴
	int deleteMember(String memberId);
	
	// 회원 아이디 찾기
	String searchId(String email);
	
	// 비밀번호 찾기
	int searchPwd(Member m);
	
	// 비밀번호 수정(로그인 x)
	int changePwd(Member m);
}
