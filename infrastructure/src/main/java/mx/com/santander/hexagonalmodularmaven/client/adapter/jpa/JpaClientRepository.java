package mx.com.santander.hexagonalmodularmaven.client.adapter.jpa;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import mx.com.santander.hexagonalmodularmaven.client.adapter.entity.ClientEntity;

@Repository
public interface JpaClientRepository extends JpaRepository<ClientEntity, Long> {
}