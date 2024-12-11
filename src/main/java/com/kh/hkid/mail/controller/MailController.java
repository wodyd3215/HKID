package com.kh.hkid.mail.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class MailController {

	private static JavaMailSender sender = null;
	
	@Autowired
	public MailController(JavaMailSender sender) {
		this.sender = sender;
	}
	
	@RequestMapping(value="send", produces="application/json; charset=UTF-8")
	@ResponseBody
	public static String mail(String email, String subject, String content) {
		// 난수 생성 Random 클래스
		Random random = new Random();
        
        // 100000 ~ 999999 사이의 난수 생성
		String randomNumber = String.valueOf(100000 + random.nextInt(900000));

		
        System.out.println("이메일 : " + email);
        System.out.println("제목 : " + subject);
        System.out.println("내용 : " + content);
        
		//메세지 생성
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject(subject);
		message.setText(content + randomNumber);
		
		System.out.println("이메일 메세지 생성완료");
		
		String[] to = {email};
		message.setTo(to);
		
		String[] cc = {};
		message.setCc(cc);
		
		System.out.println("메세지 정보" + message);
		
		sender.send(message);
		
		System.out.println("이메일 메세지 전송 완료");
		
		return new Gson().toJson(randomNumber);
	}
}
