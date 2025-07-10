package mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.JpaClientRepository;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.port.repository.ClientRepository;

@Repository
public class ClientRepositoryJpa implements ClientRepository {
    private final JpaClientRepository jpaClientRepository;

    public ClientRepositoryJpa(JpaClientRepository jpaClientRepository) {
        this.jpaClientRepository = jpaClientRepository;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return jpaClientRepository.findById(id);
    }

    @Override
    public Client save(Client client) {
        return jpaClientRepository.save(client);
    }

    @Override
    public void deleteById(Long id) {
        jpaClientRepository.deleteById(id);
    }

    @Override
    public List<Client> findAll() {
        return jpaClientRepository.findAll();
    }
}