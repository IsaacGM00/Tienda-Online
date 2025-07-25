package mx.com.santander.hexagonalmodularmaven.sale.adapter.jpa.dao;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.adapter.jpa.SpringClientRepository;
import mx.com.santander.hexagonalmodularmaven.sale.port.dao.DaoClientValidation;

@Component
@RequiredArgsConstructor

public class ValidationClientAdapter implements DaoClientValidation{
    private final SpringClientRepository jpaClientRepository;

    @Override
    public boolean existingClient(Long id){
        return jpaClientRepository.existsById(id);
    }
}