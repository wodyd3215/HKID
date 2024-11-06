package com.kh.hkid.product.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
