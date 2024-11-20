package com.kh.hkid.diary.model.vo;

import lombok.Data;

@Data
public class Diary {
	private int diaryNo;
	private String diaryTitle;
	private String diaryContent;
	private String createDate;
	private String status;
	private String writer;
	private int memberNo;
	private int foodNo;
}
