package com.kh.hkid.challenge.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class ChallengeController {
	
	@RequestMapping("ch.m")
	public String challenge() {
		return "challenge/challengeM";
	}

}
