package mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.SpringClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.adapter.mapper.MapperClient;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.dao.DaoClient;

@Repository
public class JpaClientAdapterDao implements DaoClient {

    private final SpringClientRepository jpaClientRepository;
    private final MapperClient mapperClient;

    public JpaClientAdapterDao(SpringClientRepository jpaClientRepository, MapperClient mapperClient) {
        this.jpaClientRepository = jpaClientRepository;
        this.mapperClient = mapperClient;
    }

    @Override
    public Client getById(Long id) {
        return jpaClientRepository.findById(id)
            .map(mapperClient::toDomain)
            .orElse(null); 
    }

    @Override
    public List<Client> getAll() {
        return jpaClientRepository.findAll()
            .stream()
            .map(mapperClient::toDomain)
            .collect(Collectors.toList());
    }
}
