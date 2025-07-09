package mx.com.santander.hexagonalmodularmaven.message.adapter.kafka.repository;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.message.adapter.kafka.KafkaProducerAdapter;
import mx.com.santander.hexagonalmodularmaven.message.port.repository.MessageRepository;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProducerRepository implements MessageRepository {
    private final KafkaProducerAdapter kafkaProducerAdapter;
    @Override
    public String publishMessage(String message) {
        return kafkaProducerAdapter.produceMessage(message);
    }
}
