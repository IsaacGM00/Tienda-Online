package mx.com.santander.hexagonalmodularmaven.message.adapter.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class KafkaConsumerAdapter {
    @KafkaListener(topics = "test-topic",groupId = "my-consumer-group")
     public void consumeMessage(String message) {
        log.info("Mensaje consumido: " + message);
    }
}
