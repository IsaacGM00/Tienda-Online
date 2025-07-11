package mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.JpaProductRepository;
import mx.com.santander.hexagonalmodularmaven.product.adapter.mapper.MapperProduct;
import mx.com.santander.hexagonalmodularmaven.product.port.dao.DaoProduct;

@Repository
public class JpaProductAdapterDao implements DaoProduct{
    
    private final JpaProductRepository jpaProductRepository;
    private final MapperProduct mapperProduct;

    public JpaProductAdapterDao(JpaProductRepository jpaProductRepository, MapperProduct mapperProduct){
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
        .collect(Collectors.toList());
    }

}