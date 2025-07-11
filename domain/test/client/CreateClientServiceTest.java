import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.service.CreateClientService;

@ExtendWith(MockitoExtension.class)
public class CreateClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private CreateClientService createClientService;

    @Test
    void createClientTest(){

        Client client = new Client(null, "Isaac", "Gutiérrez", "igmendez@minsait.com", "5572964245", "Calle Fulana 4");
        Client saveClient = new Client(1,"Isaac", "Gutiérrez", "igmendez@minsait.com", "5572964245", "Calle Fulana 4");

        when(clientRepository.save(client)).thenReturn(saveClient);
        Client resultClient = createClientService.execute(client);

        assertEquals(1, resultClient.getId());
    }
}