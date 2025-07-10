package mx.com.santander.hexagonalmodularmaven.client.port.repository;

import java.util.List;
import java.util.Optional;

import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;

public interface ClientRepository {
    Optional<Client> findById(Long id);
    Client save(Client client);
    void deleteById(Long id);
    List<Client> findAll();
    Client update(Long id, Client client);
}