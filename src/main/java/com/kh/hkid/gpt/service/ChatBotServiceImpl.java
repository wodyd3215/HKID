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
	
	private final List<Map<String, String>> chatHistory = new ArrayList<>();
	
	@Override
    public String getChatbotResponse(String userMessage) {
        RestTemplate restTemplate = new RestTemplate();
        
     // StringHttpMessageConverter를 UTF-8로 설정하여 인코딩을 처리
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter(StandardCharsets.UTF_8));

        // 요청 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);
        headers.set("Content-Type", "application/json; charset=UTF-8");

        // "messages" 배열 생성
        List<Map<String, String>> messages = new ArrayList<>(chatHistory);
        
        // 시스템 메시지 추가 (프롬프트 설계 반영)
        if (chatHistory.isEmpty()) {
            Map<String, String> systemMessage = new HashMap<>();
            systemMessage.put("role", "system");
            systemMessage.put("content", "너는 10년차 헬스트레이너야. 운동을 처음시작하는사람들에게 다른설명 필요없이 초보자들이 입력하는 운동들로 운동루틴을 짜줘");
            messages.add(systemMessage);
        }
        
        // 사용자 메시지 추가
        Map<String, String> userMessageMap = new HashMap<>();
        userMessageMap.put("role", "user");
        userMessageMap.put("content", userMessage);
        messages.add(userMessageMap);
        
        // 요청 본문 설정
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-4o-mini");
        requestBody.put("messages", messages);
        requestBody.put("max_tokens", 1000);

        // HTTP 요청 생성
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        // OpenAI API 호출
        ResponseEntity<Map> response = restTemplate.postForEntity(OPENAI_API_URL, request, Map.class);
        
        // 응답 처리
        String responseMessage = "오류가 발생했습니다. 다시 시도해 주세요.";
        if (response.getBody() != null && response.getBody().containsKey("choices")) {
            List<Map<String, Object>> choices = (List<Map<String, Object>>) response.getBody().get("choices");
            if (!choices.isEmpty()) {
                Map<String, Object> choice = choices.get(0);
                Map<String, Object> messageResponse = (Map<String, Object>) choice.get("message");
                responseMessage = (String) messageResponse.get("content");
            }
        }
        
        // 대화 히스토리에 추가
        chatHistory.add(userMessageMap);
        Map<String, String> botMessageMap = new HashMap<>();
        botMessageMap.put("role", "assistant");
        botMessageMap.put("content", responseMessage);
        chatHistory.add(botMessageMap);

        return responseMessage;
    }
}