package com.kh.hkid.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.hkid.chatting.model.vo.Message;
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
	
	// 회원 정보 변경(비밀번호)
	public int updatePwd(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updatePwd", m);
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
	
	// 비밀번호 수정(로그인 x)
	public int changePwd(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.changePwd", m);
	}
	
	public int updateMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.updateMember", m);
	}
	
	public int imgChangeAjax(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.update("memberMapper.imgChangeAjax", m);
	}
	
	// 회원 유무 판단
	public int searchMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.searchMember", m);
	}
	
	// 소셜로그인
	public Member socialLoginMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.socialLoginMember", m);
	}
	
	// 소셜 회원가입
	public int insertSocialMember(SqlSessionTemplate sqlSession, Member m) {
		return sqlSession.insert("memberMapper.insertSocialMember", m);
	}
	
	// 유저 닉네임 조회
	public ArrayList<Member> searchNickName(SqlSessionTemplate sqlSession, String nickName) {
		return (ArrayList)sqlSession.selectList("memberMapper.searchNickName", nickName);
	}
	
	// 발신자 정보
	public Member senderInfo(SqlSessionTemplate sqlSession, Message m) {
		return sqlSession.selectOne("memberMapper.senderInfo", m);
	}
	
	// 계정 복구 신청
	public int recoveryApply(SqlSessionTemplate sqlSession, int memberNo) {
		return sqlSession.insert("memberMapper.recoveryApply", memberNo);
	}
	
	// 이메일 중복 체크
	public int emailCheck(SqlSessionTemplate sqlSession, String email) {
		return sqlSession.selectOne("memberMapper.emailCheck", email);
	}
}
