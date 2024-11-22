package com.kh.hkid.gpt.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//ChatService 구현체
@Service
public class ChatBotServiceImpl implements ChatbotService{//1234
	
	private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
	
	@Value("${openai.api.key}")
    private String API_KEY;
	
    public String getChatbotResponse(String userMessage) {
        RestTemplate restTemplate = new RestTemplate();
        
     // StringHttpMessageConverter를 UTF-8로 설정하여 인코딩을 처리
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(StandardCharsets.UTF_8));

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.set("Content-Type", "application/json; charset=UTF-8");

        // 요청 본문 설정
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4o-mini");

        // "messages" 배열 생성
        List<Map<String, String>> messages = new ArrayList<>();
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", userMessage);
        messages.add(message);
        requestBody.put("messages", messages);
        requestBody.put("max_tokens", 1000);

        // HTTP 요청 생성
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        // OpenAI API 호출
        ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_API_URL, request, Map.class);
        
        // 응답 처리
        if (response.getBody() != null && response.getBody().containsKey("choices")) {
            // 응답에서 "choices" 목록을 가져옵니다.
            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            if (!choices.isEmpty()) {
                // 첫 번째 선택 항목에서 "message"를 가져옵니다.
                Map<String, Object> choice = choices.get(0);
                Map<String, Object> messageResponse = (Map<String, Object>) choice.get("message");
                return (String) messageResponse.get("content");  // "content"에서 답변을 추출
            }
        }

        return "오류가 발생했습니다. 다시 시도해 주세요.";
    }
}