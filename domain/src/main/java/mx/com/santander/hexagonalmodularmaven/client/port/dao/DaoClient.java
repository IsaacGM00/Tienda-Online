package mx.com.santander.hexagonalmodularmaven.client.port.dao;

import java.util.List;

import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;

public interface DaoClient {
    Client getById(Long id);
    List<Client> getAll();
}