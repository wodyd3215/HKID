package com.kh.hkid.payment.model.vo;

import lombok.Data;

@Data
public class KakaoPayReady {
	private String tid; // 결제고유번호
	private String next_redirect_mobile_url; // 요청한 클라이언트가 모바일 웹
	private String next_redirect_pc_url; // 요청한 클라이언트가 PC 웹
	private String partner_order_id; // 가맹점 주문번호
}
