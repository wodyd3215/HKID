package com.kh.hkid.gpt.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kh.hkid.gpt.service.ChatbotService;

@Controller
public class ExGptController {

    @Autowired
    private ChatbotService chatbotService;

    // 채팅 페이지 반환
    @GetMapping("chat.ex")
    public String getChatPage() {
        return "common/exGpt"; // /WEB-INF/views/chat.jsp를 반환 2134
    }

    // OpenAI API를 통해 메시지 응답 처리
    @ResponseBody
    @PostMapping("chat/message")
    public Map<String, String> getChatbotResponse(@RequestBody Map<String, String> userInput) {
        String userMessage = userInput.get("message");
        String responseMessage = chatbotService.getChatbotResponse("다음 운동으로 AI 추천 루틴을 생성하세요: " + userMessage);

        // 응답을 HashMap을 사용하여 반환
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("response", responseMessage);
        return responseMap;
    }
}
