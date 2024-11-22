package com.kh.hkid.phase.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Phase {
	private int purchaseNo;
	private int memberNo;
	private int totalPurchase;
	private int quantity;
	private char refund;
	private Date purchaseDate;
	private String request;
	private String paymentMethod;
	private String paymentStatus;
	private String bankCode;
	private String bankName;
	private String memberName;
	private String address;
	private String phone;
	private String email;
	private String productName;
	private int price;
}
