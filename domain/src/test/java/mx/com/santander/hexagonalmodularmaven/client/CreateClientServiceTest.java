package mx.com.santander.hexagonalmodularmaven.client;

import mx.com.santander.hexagonalmodularmaven.client.model.dto.command.CreateClientCommand;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.service.CreateClientService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class CreateClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private CreateClientService createClientService;
    
    @Test
    void createClientTest() {
        CreateClientCommand command = new CreateClientCommand("Isaac", "Gutiérrez", "igmendez@minsait.com", "5572964245", "Calle Fulana 4");
        Client savedClient = new Client(1L, "Isaac", "Gutiérrez", "igmendez@minsait.com", "5572964245", "Calle Fulana 4");

        when(clientRepository.save(any(Client.class))).thenReturn(savedClient);
        Client resultClient = createClientService.execute(command);

        assertEquals(1L, resultClient.getId());
    }
}