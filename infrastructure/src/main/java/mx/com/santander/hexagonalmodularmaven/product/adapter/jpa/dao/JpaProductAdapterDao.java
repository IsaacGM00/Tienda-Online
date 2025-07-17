package mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.SpringProductRepository;
import mx.com.santander.hexagonalmodularmaven.product.adapter.mapper.MapperProduct;
import mx.com.santander.hexagonalmodularmaven.product.port.dao.DaoProduct;

@Repository
public class JpaProductAdapterDao implements DaoProduct{
    
    private final SpringProductRepository jpaProductRepository;
    private final MapperProduct mapperProduct;

    public JpaProductAdapterDao(SpringProductRepository jpaProductRepository, MapperProduct mapperProduct){
        this.jpaProductRepository = jpaProductRepository;
        this.mapperProduct = mapperProduct;
    }

    @Override
    public Product getById(Long id) {
        return jpaProductRepository.findById(id)
            .map(mapperProduct::toDomain)
            .orElse(null); 
    }

    @Override
    public List<Product> getAll(){
        return jpaProductRepository.findAll()
        .stream()
        .map(mapperProduct::toDomain)
        .toList();
    }

}