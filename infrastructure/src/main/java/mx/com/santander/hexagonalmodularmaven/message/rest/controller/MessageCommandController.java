package mx.com.santander.hexagonalmodularmaven.message.rest.controller;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.message.command.MessageCreateHandler;
import mx.com.santander.hexagonalmodularmaven.message.model.dto.command.MessageCreateCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/message")
public class MessageCommandController {
    private final MessageCreateHandler messageCreateHandler;
    @PostMapping("/publish")
    public String create(@RequestBody MessageCreateCommand messageCreateCommand) {
        return messageCreateHandler.execute(messageCreateCommand.getMessage());
    }
}
