package dev.arianit.orchestrartor.client.rag;

import dev.arianit.orchestrartor.client.rag.dto.EvalResponse;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class RagTools {

    private final RagServiceClient ragServiceClient;

    public RagTools(RagServiceClient ragServiceClient) {
        this.ragServiceClient = ragServiceClient;
    }

    @Tool(description = """
        Ask the knowledge base (RAG) to answer user questions.
        Input:
        - question: the user query
        Output:
        - String with the best possible answer.
    """)
    public String askKnowledgeBase(String question) {
        EvalResponse response = ragServiceClient.ask(question);
        return response.answer(); // ose bëje formatim nëse do më shumë info
    }
}
