package mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.product.adapter.entity.ProductEntity;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.JpaProductRepository;
import mx.com.santander.hexagonalmodularmaven.product.adapter.mapper.MapperProduct;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;

@Repository
public class ProductRepositoryJpa implements ProductRepository{
    private final JpaProductRepository jpaProductRepository;
    private final MapperProduct mapperProduct;

    public ProductRepositoryJpa(JpaProductRepository jpaProductRepository, MapperProduct mapperProduct){
        this.jpaProductRepository = jpaProductRepository;
        this.mapperProduct = mapperProduct;
    }

    @Override
    public Optional<Product> findById(Long id){
        return jpaProductRepository.findById(id)
        .map(mapperProduct::toDomain);
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapperProduct.toEntity(product);
        ProductEntity saved = jpaProductRepository.save(entity);
        return mapperProduct.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        jpaProductRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return jpaProductRepository.findAll()
            .stream()
            .map(mapperProduct::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<ProductEntity> existingEntityOpt = jpaProductRepository.findById(id);
        if (existingEntityOpt.isPresent()) {
            ProductEntity existingEntity = existingEntityOpt.get();

            existingEntity.setNombre(product.getNombre());
            existingEntity.setPrecio(product.getPrecio());
            existingEntity.setStock(product.getStock());

            ProductEntity updatedEntity = jpaProductRepository.save(existingEntity);
            return mapperProduct.toDomain(updatedEntity);
        } else {
            throw new RuntimeException("Producto con id " + id + "no encontrado");
        }
    }
}