package mx.com.santander.hexagonalmodularmaven.sale.adapter.jpa.dao;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.adapter.mapper.MapperProduct;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.SpringProductRepository;

@RequiredArgsConstructor
@Component
public class DataProductAdapter {
    private final SpringProductRepository jpaProductRepository;
    private final MapperProduct mapperProduct;

    public Product obtainData(Long id){
        return jpaProductRepository.findById(id)
            .map(mapperProduct::toDomain)
            .orElseThrow(() -> new RuntimeException("Product not found"));
    }
}