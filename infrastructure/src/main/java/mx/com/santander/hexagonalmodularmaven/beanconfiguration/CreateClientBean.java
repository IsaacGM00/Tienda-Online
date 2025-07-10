package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.service.CreateClientService;

@Configuration
public class CreateClientBean {
    @Bean
    public CreateClientService createClientService(ClientRepository clientRepository){
        return new CreateClientService(clientRepository);
    }
}