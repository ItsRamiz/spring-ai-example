package spring.ai.example.spring_ai_demo.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final ChatModel chatModel;

    public AiService(ChatModel chatModel)
    {
        this.chatModel = chatModel;
    }

    public String analyzeTicket(String text) {

        SystemMessage systemMessage = new SystemMessage("You are a senior support engineer.");
        UserMessage userMessage = new UserMessage(text);

        Prompt prompt = new Prompt(
                java.util.List.of(
                        systemMessage,
                        userMessage
                ),
                OpenAiChatOptions.builder()
                        .model("gpt-4.1-mini")
                        .temperature(0.2)
                        .maxTokens(250)
                        .build()
        );

        ChatResponse response = chatModel.call(prompt);

        return response.getResult()
                .getOutput()
                .getText();
    }
}