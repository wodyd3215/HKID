package com.kh.hkid.product.model.vo;

import java.sql.Date;

import lombok.Data;


@Data
public class Review {
	private int reviewNo;
	private int productNo;
	private int memberNo;
	private String reviewContent;
	private double reviewRate;
	private Date reviewDate;
}
