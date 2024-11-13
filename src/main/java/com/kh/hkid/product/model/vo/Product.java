package com.kh.hkid.product.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Product {
	private int productNo;
	private int memberNo;
	private String productName;
	private String content;
	private int quantity;
	private int price;
	private String category;
	private Date registrationDate;
	private String type;
}
