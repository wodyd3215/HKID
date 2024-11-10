package com.kh.hkid.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Member {
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
	private String isAdmain;
}
