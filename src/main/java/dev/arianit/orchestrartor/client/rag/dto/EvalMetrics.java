package dev.arianit.orchestrartor.client.rag.dto;

public record EvalMetrics(
        Double semanticSimilarity,
        Double lexicalOverlap,
        Double bleu1,
        Double bleu2,
        Double contextCoverage,
        Double answerFromContext
) {}
