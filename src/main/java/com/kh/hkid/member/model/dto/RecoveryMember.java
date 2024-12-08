package com.kh.hkid.member.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class RecoveryMember {
	private int memberNo;
	private String memberId;
	private String memberPwd;
	private String memberName;
	private String nickName;
	private String phone;
	private String email;
	private String address;
	private String detailAddress;
	private String postNo;
	private int point;
	private Date enrollDate;
	private String status;
	private String profileImg;
	private String isAdmin;
	private String isSocial;
	private Date suspensionDate;
	private Date unsuspensionDate;
}
