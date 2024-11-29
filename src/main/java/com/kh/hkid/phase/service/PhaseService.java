package com.kh.hkid.phase.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.hkid.phase.model.vo.Phase;
import com.kh.hkid.product.model.vo.Review;

public interface PhaseService {


	// 상품이랑 유저 정보 조회
	ArrayList<Phase> selectList(HashMap<String, Object> order1);

	// 결제하기 버튼 클릭 시 insert
	int insertPhase(Phase p);

	// 리뷰 등록
	int addReview(Review r);

	

}
