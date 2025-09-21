package dev.arianit.orchestrartor.client.rag.dto;

public record RetrievedChunk(
        String id,
        String content,
        String sourceFilename,
        Double score
) {}
