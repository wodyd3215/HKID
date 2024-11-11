package com.kh.hkid.member.service;

import com.kh.hkid.member.model.vo.Member;

public interface MemberService {
	
	// 회원가입
	int insertMember(Member m);
	
	// 로그인
	Member loginMember(Member m);
	
	// 회원 정보 변경(이메일)
	int updateEmail(Member m);
}
