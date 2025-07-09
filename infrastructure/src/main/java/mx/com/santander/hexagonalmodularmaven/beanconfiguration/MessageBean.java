package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import mx.com.santander.hexagonalmodularmaven.message.port.repository.MessageRepository;
import mx.com.santander.hexagonalmodularmaven.message.service.CreateMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageBean {
    @Bean
    public CreateMessageService createMessageService (MessageRepository messageRepository){
        return new CreateMessageService(messageRepository);
    }
}
