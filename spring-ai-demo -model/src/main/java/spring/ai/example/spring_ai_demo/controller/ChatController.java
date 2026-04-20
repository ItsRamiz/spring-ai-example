package spring.ai.example.spring_ai_demo.controller;

import org.springframework.web.bind.annotation.*;
import spring.ai.example.spring_ai_demo.service.AiService;

import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final AiService aiService;

    public ChatController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping()
    public Map<String, String> analyze(@RequestBody Map<String, String> request) {

        String input = request.get("message");

        String result = aiService.analyzeTicket(input);

        return Map.of(
                "input", input,
                "analysis", result
        );
    }
}