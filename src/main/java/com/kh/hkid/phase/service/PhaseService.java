package com.kh.hkid.phase.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.hkid.common.vo.PageInfo;
import com.kh.hkid.phase.model.vo.Phase;
import com.kh.hkid.product.model.vo.Review;

public interface PhaseService {


	// 상품이랑 유저 정보 조회
	ArrayList<Phase> selectList(HashMap<String, Object> order1);

	// 결제하기 버튼 클릭 시 insert
	int insertPhase(Phase p);

	// 리뷰 등록
	int addReview(Review r);

	// 리뷰 등록 날짜 가져오기
	String selectDate(Review r);

	// 구매내역 페이징
	int selectListCount(int memberNo);

	// 구매내역 리스트
	ArrayList<Phase> phaseList(int memberNo, PageInfo pi);

}
