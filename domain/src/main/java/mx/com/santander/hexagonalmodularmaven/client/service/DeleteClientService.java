package mx.com.santander.hexagonalmodularmaven.client.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;

@RequiredArgsConstructor
public class DeleteClientService {
    
    private final ClientRepository clientRepository;

    public void execute(Long id){
        clientRepository.deleteById(id);
    }

}