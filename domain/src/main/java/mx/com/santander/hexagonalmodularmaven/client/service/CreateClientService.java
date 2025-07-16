package mx.com.santander.hexagonalmodularmaven.client.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.port.message.ClientKafkaProducer;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.model.dto.command.CreateClientCommand;

@RequiredArgsConstructor
public class CreateClientService {
    private final ClientRepository clientRepository;
    private final ClientKafkaProducer clientKafkaProducer;

    public Client execute(CreateClientCommand createClientCommand){
        Client clientToCreate = new Client().requestToCreateClient(createClientCommand);
        Client clientCreated = clientRepository.create(clientToCreate);
        clientKafkaProducer.mensajeClienteCreado(clientCreated);
        return clientCreated;
    }
}