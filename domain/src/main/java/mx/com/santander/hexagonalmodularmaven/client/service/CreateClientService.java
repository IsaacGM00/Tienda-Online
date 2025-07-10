package mx.com.santander.hexagonalmodularmaven.client.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateClientService {
    private final ClientRepository clientRepository;

    public Client execute(CreateClientCommand createClientCommand){
        Client clientToCreate = new Client().requestToCreate(createClientCommand);
        return clientRepository.create(clientToCreate);
    }
}
