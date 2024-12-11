package com.kh.hkid.payment.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.kh.hkid.payment.model.vo.KakaoPayApprove;
import com.kh.hkid.payment.model.vo.KakaoPayReady;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PayServiceImpl implements PayService{
	
	static final String cid = "TC0ONETIME"; // 가맹점 테스트 코드
    static final String admin_Key = "${DEV7F998CBE0EDC371FB8991EA7D991870C8E04E}"; // 공개 조심! 본인 애플리케이션의 어드민 키를 넣어주세요
    private KakaoPayReady kakaoReady;
	
	@Override
	public KakaoPayReady kakaoPay(Map<String, Object> params) {
		 // 카카오페이 요청 양식
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("partner_order_id", "1234567890");
        parameters.add("partner_user_id", "KakaoPayTest");
        parameters.add("item_name", "params.get('name')");
        parameters.add("quantity", "params.get('productCount')");
        parameters.add("total_amount", "params.get('totalPrice')");
        parameters.add("tax_free_amount", "params.get('tax_free_amount')");
        parameters.add("approval_url", "http://localhost:7777/payment/success"); // 성공 시 redirect url
        parameters.add("cancel_url", "http://localhost:7777/payment/cancel"); // 취소 시 redirect url
        parameters.add("fail_url", "http://localhost:7777/payment/fail"); // 실패 시 redirect url
        
        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
        
        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();

        kakaoReady = restTemplate.postForObject("https://kapi.kakao.com/v1/payment/ready", requestEntity, KakaoPayReady.class);
                
        return kakaoReady;
	}

	private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();

        String auth = "KakaoAK " + admin_Key;

        httpHeaders.set("Authorization", auth);
        httpHeaders.set("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        return httpHeaders;
    }
	
	@Override
	public KakaoPayApprove kakaoPayApprove(String pgToken) {
		// 카카오 요청
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("cid", cid);
        parameters.add("tid", kakaoReady.getTid());
        parameters.add("partner_order_id", "가맹점 주문 번호");
        parameters.add("partner_user_id", "가맹점 회원 ID");
        parameters.add("pg_token", pgToken);

        // 파라미터, 헤더
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());
        
        // 외부에 보낼 url
        RestTemplate restTemplate = new RestTemplate();
        
        KakaoPayApprove approveResponse = restTemplate.postForObject(
                "https://kapi.kakao.com/v1/payment/approve",
                requestEntity,
                KakaoPayApprove.class);
                
        return approveResponse;
	}

}
