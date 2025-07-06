package dev.arianit.orchestrartor.orchestrator.controller;

import dev.arianit.orchestrartor.orchestrator.service.HrFinanceTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class HrFinanceAiController {


    private final ChatClient chatClient;
    private final HrFinanceTools hrFinanceTools;

    public HrFinanceAiController(ChatClient.Builder builder, HrFinanceTools hrFinanceTools) {
        this.chatClient = builder.build();
        this.hrFinanceTools = hrFinanceTools;
    }

    @GetMapping("/ai")
    public Flux<String> askAi(@RequestParam String message) {
        return chatClient.prompt()
                .tools(hrFinanceTools)
                .user(message)
                .stream()
                .content();
    }
}