package mx.com.santander.hexagonalmodularmaven.sale.adapter.jpa.dao;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.JpaClientRepository;
import mx.com.santander.hexagonalmodularmaven.sale.port.dao.DaoClientValidation;

@Component
@RequiredArgsConstructor

public class ValidationClientAdapter implements DaoClientValidation{
    private final JpaClientRepository jpaClientRepository;

    @Override
    public boolean existingClient(Long id){
        return jpaClientRepository.existsById(id);
    }
}