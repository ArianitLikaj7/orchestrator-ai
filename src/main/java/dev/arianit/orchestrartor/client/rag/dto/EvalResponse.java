package dev.arianit.orchestrartor.client.rag.dto;

import java.util.List;

public record EvalResponse(
        String question,
        String answer,
        List<RetrievedChunk> retrieved,
        EvalMetrics metrics,
        long latencyMs
) {}
