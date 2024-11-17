package com.kh.hkid.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class APIController {
	public static final String SERVICE_KEY = "9FXORfWwzBhnP0fr8TFDbZ%2BPSwhvq91ros5TMlZsmnkHHwRAhVE2Wnlqgk8h3oQ18eFz8hKKWSQPyQYFSSXx%2Fw%3D%3D";
	
	@ResponseBody
	@GetMapping(value="foods", produces="application/json; charset=UTF-8")
	public String getFoodInfo(String food) throws IOException {
		String url = "https://apis.data.go.kr/1471000/FoodNtrCpntDbInfo01/getFoodNtrCpntDbInq01";
		url += "?serviceKey=" + SERVICE_KEY;
		url += "&type=json";
		url += "&FOOD_NM_KR=" + URLEncoder.encode(food, "UTF-8");
		
		// 1. 요청하고자하는 url을 전달하면서 java.net.URL 객체 생성
		URL requestURL = new URL(url);
		
		// 2. 만들어진 URL객체를 가지고HttpURLConnection 객체 생성
		HttpURLConnection urlConnection = (HttpURLConnection)requestURL.openConnection();
		
		// 3. 요청에 필요한 Header정보 설정하기
		urlConnection.setRequestMethod("GET");
		
		// 4. 해당 API서버로 요청 보낸 후 입력데이터 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String result = "";
		String line;
		while((line = br.readLine()) != null) {
			result += line;
		}

		br.close();
		urlConnection.disconnect();
		
		System.out.println("result : " + result);
		
		return result;
	}
}
