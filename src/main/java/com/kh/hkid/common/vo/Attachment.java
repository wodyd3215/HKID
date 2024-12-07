package com.kh.hkid.common.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Attachment {
	private int fileNo;
	private String originName;
	private String changeName;
	private String filePath;
	private Date uploadDate;
	private String fileStatus;
	private int diaryNo;
	private int reviewNo;
	private int boardNo;
	private int chellangeNo;
	private int productNo;
}
