package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.service.DeleteClientService;

@Configuration
public class DeleteClientBean {
    @Bean
    public DeleteClientService deleteClientService(ClientRepository clientRepository){
        return new DeleteClientService(clientRepository);
    }
}