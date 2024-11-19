package com.kh.hkid.diet.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Diet {
	private int foodNo;
	private int memberNo;
	private int totalKcal;
	private int totalCarbo;
	private int totalProtein;
	private int totalFat;
	private Date saveDate;
}
