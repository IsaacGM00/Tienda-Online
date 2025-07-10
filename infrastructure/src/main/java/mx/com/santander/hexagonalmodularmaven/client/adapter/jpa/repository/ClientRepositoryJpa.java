package mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.repository;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.JpaClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.adapter.mapper.MapperClient;
import mx.com.santander.hexagonalmodularmaven.client.adapter.entity.ClientEntity;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;

@Repository
public class ClientRepositoryJpa implements ClientRepository {

    private final JpaClientRepository jpaClientRepository;
    private final MapperClient mapperClient;

    public ClientRepositoryJpa(JpaClientRepository jpaClientRepository, MapperClient mapperClient) {
        this.jpaClientRepository = jpaClientRepository;
        this.mapperClient = mapperClient;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return jpaClientRepository.findById(id)
            .map(mapperClient::toDomain);
    }

    @Override
    public Client save(Client client) {
        ClientEntity entity = mapperClient.toEntity(client);
        ClientEntity saved = jpaClientRepository.save(entity);
        return mapperClient.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaClientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return jpaClientRepository.findAll()
            .stream()
            .map(mapperClient::toDomain)
            .collect(Collectors.toList());
    }
}