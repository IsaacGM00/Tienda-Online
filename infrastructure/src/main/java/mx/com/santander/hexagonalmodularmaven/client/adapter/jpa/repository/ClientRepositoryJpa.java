package mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.SpringClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.adapter.mapper.MapperClient;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.adapter.entity.ClientEntity;
import mx.com.santander.hexagonalmodularmaven.client.model.exception.ClientException;

@Repository
public class ClientRepositoryJpa implements ClientRepository{
    private final MapperClient mapperClient;
    private final SpringClientRepository springClientRepository;

    public ClientRepositoryJpa(MapperClient mapperClient, SpringClientRepository springClientRepository){
        this.mapperClient = mapperClient;
        this.springClientRepository = springClientRepository;
    }

    @Override
    public Client create(Client client){
        return mapperClient.toDomain(springClientRepository.save(mapperClient.toEntity(client)));
    }

    @Override
    public Client update(Long id, Client client) {
        ClientEntity existingEntity = springClientRepository.findById(id).
                orElseThrow(()-> new ClientException("Cliente inexistente"));
        existingEntity.setNombre(client.getNombre());
        existingEntity.setApellido(client.getApellido());
        existingEntity.setDireccion(client.getDireccion());
        existingEntity.setEmail(client.getEmail());
        existingEntity.setTelefono(client.getTelefono());
        ClientEntity updateClient = springClientRepository.save(existingEntity);
        return mapperClient.toDomain(updateClient);
    }

    @Override
    public void deleteById(Long id) {
        springClientRepository.deleteById(id);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return springClientRepository.findById(id)
        .map(mapperClient::toDomain);
    }

    @Override
    public List<Client> findAll() {
        return springClientRepository.findAll()
            .stream()
            .map(mapperClient::toDomain)
            .toList();
    }

    @Override
    public Client save(Client client) {
        return mapperClient.toDomain(springClientRepository.save(mapperClient.toEntity(client)));
    }
}