package mx.com.santander.hexagonalmodularmaven.client.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.dao.DaoClient;

@RequiredArgsConstructor
public class GetCompleteClientService {
    
    private final DaoClient daoClient;

    public List<Client> execute(){
        return daoClient.getAll();
    }
}