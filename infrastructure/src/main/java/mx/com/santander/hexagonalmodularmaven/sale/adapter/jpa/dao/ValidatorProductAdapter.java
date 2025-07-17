package mx.com.santander.hexagonalmodularmaven.sale.adapter.jpa.dao;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.SpringProductRepository;

@RequiredArgsConstructor
@Component

public class ValidatorProductAdapter {
    private final SpringProductRepository jpaProductRepository;

    public boolean existingProduct(Long id){
        return jpaProductRepository.existsById(id);
    }
}