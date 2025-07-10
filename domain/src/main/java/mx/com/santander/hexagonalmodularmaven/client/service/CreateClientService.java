package mx.com.santander.hexagonalmodularmaven.client.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.model.dto.command.CreateClientCommand;

@RequiredArgsConstructor
public class CreateClientService {
    private final ClientRepository clientRepository;

    public Client execute(CreateClientCommand createClientCommand){
        Client clientToCreate = Client.fromCommand(createClientCommand);
        return clientRepository.save(clientToCreate);
    }
}
