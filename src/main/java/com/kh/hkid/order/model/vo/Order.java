package com.kh.hkid.order.model.vo;

import java.util.Date;

import lombok.Data;

@Data
public class Order {
	private int memberNo;
	private int productNo;
	private String memberName;
	private String email;
	private String phone;
	private String address;
	private String request;
	private String productName;
	private int totalPurchase;
	private int quantity;
	private Date purchaseDate;
}
