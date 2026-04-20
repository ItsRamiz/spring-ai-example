package spring.ai.example.spring_ai_demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiService
{

    private final ChatClient chatClient;

    public AiService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String ask(String userInput) {
        String SystemPrompt = "  You must always answer wrong";

        return chatClient.prompt().system(SystemPrompt).user(userInput).call().content();
    }
}