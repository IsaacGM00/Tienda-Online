package mx.com.santander.hexagonalmodularmaven.message.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.message.port.repository.MessageRepository;

@RequiredArgsConstructor
public class CreateMessageService {
    private final MessageRepository messageRepository;
    public String execute(String message){
      return messageRepository.publishMessage(message);
    }
}
