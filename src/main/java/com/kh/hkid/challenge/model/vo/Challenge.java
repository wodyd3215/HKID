package com.kh.hkid.challenge.model.vo;

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
public class Challenge {
	private int challengeNo;
	private String challengeTitle;
	private String startDate;
	private String endDate;
	private String thumbnail;

}
