package com.kh.hkid.exercise.model.vo;

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
public class Exercise {
	private int exerciseNo;
	private int partNo;
	private String exerciseName;
	private String exerciseDifficulty;
	private String exerciserDescription;
	private String exerciseImg;

	
}
