package dev.arianit.orchestrartor.orchestrator.controller;

import dev.arianit.orchestrartor.orchestrator.service.HrTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class HrAiController {


    private final ChatClient chatClient;
    private final HrTools hrTools;

    public HrAiController(ChatClient.Builder builder,
                          HrTools hrTools,
                          ChatMemory chatMemory) {
        this.chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
        this.hrTools = hrTools;
    }

    @GetMapping("/hr/ask")
    public Flux<String> askAi(@RequestParam String message) {
        return chatClient.prompt()
                .tools(hrTools)
                .user(message)
                .stream()
                .content();
    }

}