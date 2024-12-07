package com.kh.hkid.admin.model.vo;

import lombok.Data;

@Data
public class SuspensionMember {
	private int memberNo;
	private String nickname;
	private String suspensionDate;
	private String unSuspensionDate;
	private int suspension;
	private String suspensionComment;
}
