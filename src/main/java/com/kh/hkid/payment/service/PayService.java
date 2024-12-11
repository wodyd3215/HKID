package com.kh.hkid.payment.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.kh.hkid.payment.model.vo.KakaoPayApprove;
import com.kh.hkid.payment.model.vo.KakaoPayReady;

public interface PayService {
	KakaoPayReady kakaoPay(Map<String, Object> params);
	
	KakaoPayApprove kakaoPayApprove(String pgToken);
}
