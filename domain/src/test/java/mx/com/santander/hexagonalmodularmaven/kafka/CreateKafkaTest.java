package mx.com.santander.hexagonalmodularmaven.kafka;

import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.message.ClientKafkaProducer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
class CreateKafkaTest {

    @Mock
    private KafkaTemplate<String, Client> kafkaTemplate;

    @InjectMocks
    private ClientKafkaProducer clientKafkaProducer;

    @Test
    void testSendClientCreatedEvent() {
        // Arrange
        Client client = new Client(1L, "Isaac", "Gutiérrez", "igmendez@minsait.com", "5572964245", "Calle Fulana 4");

        // Act
        clientKafkaProducer.mensajeClienteCreado(client);

        // Assert
        verify(kafkaTemplate, times(1)).send("client-topic", client);
    }
}