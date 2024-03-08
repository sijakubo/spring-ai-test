package de.sijakubo.aitest;

import de.sijakubo.aitest.resources.ResponseResource;
import de.sijakubo.aitest.resources.TranslationResource;
import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {

    private final ChatClient chatClient;

    public AiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/quote")
    public ResponseResource theOfficeQuote() {
        return new ResponseResource(chatClient.call("Tell a random funny 'The Office' quote"));
    }

    @PostMapping("/translate")
    public ResponseResource translator(@RequestBody TranslationResource translationResource) {
        return new ResponseResource(chatClient.call("Translate the following text from langauge: %s to language: %s. The text is: %s"
            .formatted(
                translationResource.sourceLanguage(),
                translationResource.targetLanguage(),
                translationResource.text()
            )));
    }
}
