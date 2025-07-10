package mx.com.santander.hexagonalmodularmaven.client.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;

@RequiredArgsConstructor
public class UpdateClientService {
    private final ClientRepository clientRepository;

    public Client execute(Long id, Client updateClient){
        return clientRepository.update(id, updateClient);
    }
}