package com.example.langChain4j;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.langchain4j.chain.ConversationalChain;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.ollama.OllamaChatModel;

@RestController
@Scope("session")
public class ChatController {
    // This class will handle chat-related requests and responses
    // It will use the LangChain4j library to process chat messages
    private final ChatLanguageModel chatLanguageModel;
    private final ChatMemory chatMemory;
    // Constructor to initialize the chat language model
    public ChatController() {
        // Initialize the chat language model with Ollama
        this.chatLanguageModel = OllamaChatModel.builder()
                .baseUrl("http://localhost:11434")
                .modelName("gemma3:4b")
                .build();
        // Initialize the chat memory with a message window of size 10
        this.chatMemory = MessageWindowChatMemory.withMaxMessages(10);
    }

    @PostMapping("/chatWithMemory")
    public String chatWithMemory(@RequestBody String message) {
        System.out.println("chatWithMemory Received message: " + message);
        ConversationalChain chain = ConversationalChain.builder()
                .chatMemory(chatMemory)
                .chatLanguageModel(chatLanguageModel)
                .build();
        String response = chain.execute(message);
        System.out.println("chatWithMemory Response: " + response);
        return response;

    }

    @PostMapping("/chatWithoutMemory")
    public String chatWithoutMemory(@RequestBody String message) {
        System.out.println("Received message: " + message);
        String response = chatLanguageModel.generate(message);
        System.out.println("Response: " + response);
        return response;
    }

    // Additional methods for handling chat functionality can be added here 
}
