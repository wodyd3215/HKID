package com.kh.hkid.phase.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.kh.hkid.phase.model.vo.Phase;

public interface PhaseService {

	// 상품이랑 유저 정보 조회
	ArrayList<Phase> getProduct(HashMap<String, Object> order1);

}
