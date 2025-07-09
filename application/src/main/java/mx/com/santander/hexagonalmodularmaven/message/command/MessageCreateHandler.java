package mx.com.santander.hexagonalmodularmaven.message.command;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.message.service.CreateMessageService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageCreateHandler {
    private final CreateMessageService createMessageService;
    public String execute (String message){
        return createMessageService.execute(message);
    }
}
