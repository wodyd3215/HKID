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
public class ChallengeBoard {
	private int challengeBoardNo;
	private int memberNo;
	private int challengeNo;
	private String chaTitle;
	private String chaContent;
	private String chaDate;
	private int commentCount;
	private String nickName;
	private String challengeTitle;
	private String originName;
	private String changeName;
	private String file_path;
}
