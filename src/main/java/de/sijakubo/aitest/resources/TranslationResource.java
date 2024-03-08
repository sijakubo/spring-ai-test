package de.sijakubo.aitest.resources;

public record TranslationResource(
    String sourceLanguage,
    String targetLanguage,
    String text
) {

}
