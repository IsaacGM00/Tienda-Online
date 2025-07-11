import static org.mockito.Mockito.*;

import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.service.ClientKafkaProducer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
public class ClientKafkaTest {

    @Mock
    private KafkaTemplate<String, Client> kafkaTemplate;

    @InjectMocks
    private ClientKafkaProducer clientKafkaProducer;

    @Test
    void testSendClientCreatedEvent() {
        // Arrange
        Client client = new Client(1, "Isaac", "Gutiérrez", "igmendez@minsait.com", "5572964245", "Calle Fulana 4");

        // Act
        clientKafkaProducer.sendClientCreatedEvent(client);

        // Assert
        verify(kafkaTemplate, times(1)).send("client-topic", client);
    }
}