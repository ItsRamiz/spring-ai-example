package spring.ai.example.spring_ai_demo.controller;

import spring.ai.example.spring_ai_demo.service.AiService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/chatclient")
public class ChatController {

    private final AiService aiService;

    public ChatController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping
    public Map<String, String> chat(@RequestBody Map<String, String> request)
    {

        String userInput = request.get("message");

        String response = aiService.ask(userInput);

        return Map.of(
                "input", userInput,
                "response", response
        );
    }
}


