package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.client.port.dao.DaoClient;
import mx.com.santander.hexagonalmodularmaven.client.port.message.ClientKafkaProducer;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.service.ClientByIdservice;
import mx.com.santander.hexagonalmodularmaven.client.service.CreateClientService;
import mx.com.santander.hexagonalmodularmaven.client.service.DeleteClientService;
import mx.com.santander.hexagonalmodularmaven.client.service.GetCompleteClientService;
import mx.com.santander.hexagonalmodularmaven.client.service.UpdateClientService;

@Configuration
public class ClientBean {
    @Bean
    public GetCompleteClientService getCompleteClientService(DaoClient daoClient){
        return new GetCompleteClientService(daoClient);
    }

    @Bean
    public ClientByIdservice clientByIdservice(DaoClient daoClient){
        return new ClientByIdservice(daoClient);
    }

    @Bean
    public CreateClientService createClientService(ClientRepository clientRepository, ClientKafkaProducer clientKafkaProducer){
        return new CreateClientService(clientRepository, clientKafkaProducer);
    }

    @Bean
    public UpdateClientService updateClientService(ClientRepository clientRepository){
        return new UpdateClientService(clientRepository);
    }

    @Bean
    public DeleteClientService deleteClientService(ClientRepository clientRepository){
        return new DeleteClientService(clientRepository);
    }
}