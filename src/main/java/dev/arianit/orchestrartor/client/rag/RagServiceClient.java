package dev.arianit.orchestrartor.client.rag;

import dev.arianit.orchestrartor.client.rag.dto.EvalResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Flux;

@FeignClient(
        name = "rag-service",
        url = "http://localhost:8081",
        path = "/api/rag/qa"
)
public interface RagServiceClient {

    @GetMapping("/api/qa")
    EvalResponse ask(@RequestParam("question") String question);

    @GetMapping("/api/qa/stream")
    Flux<String> askStream(@RequestParam("question") String question);
}
