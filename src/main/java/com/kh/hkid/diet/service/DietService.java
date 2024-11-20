package com.kh.hkid.diet.service;

import com.kh.hkid.diet.model.vo.Diet;

public interface DietService {
	
	// 영양정보 저장
	public int saveDietInfo(Diet d);
	
	public Diet loadDietAjax(int memberNo);
}
