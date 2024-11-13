package com.kh.hkid.member.service;

import java.util.ArrayList;

import com.kh.hkid.diary.model.vo.Diary;
import com.kh.hkid.member.model.vo.Member;

public interface MemberService {
	
	// 회원가입
	int insertMember(Member m);
	
	// 로그인
	Member loginMember(Member m);
	
	// 회원 정보 변경(이메일)
	int updateEmail(Member m);
	
	// 회원 정보 변경(전화번호)
	int updatePhone(Member m);
	
	// 회원 정보 변경(비밀번호)
	int updatePwd(Member m);
	
	// 회원 정보 변경(주소)
	int updateAddress(Member m);
	
	// 회원 탈퇴
	int deleteMember(String memberId);
}
