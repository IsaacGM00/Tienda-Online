package mx.com.santander.hexagonalmodularmaven.client.port.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    
}