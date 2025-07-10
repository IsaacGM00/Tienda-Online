package mx.com.santander.hexagonalmodularmaven.client.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.dao.DaoClient;

@RequiredArgsConstructor
public class ClientByIdservice {
    private final DaoClient daoClient;

    public Client execute(long id){
        return daoClient.getById(id);
    }
}