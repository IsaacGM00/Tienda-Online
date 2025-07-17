package mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.product.adapter.entity.ProductEntity;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.model.exception.ProductNotFound;
import mx.com.santander.hexagonalmodularmaven.product.adapter.jpa.SpringProductRepository;
import mx.com.santander.hexagonalmodularmaven.product.adapter.mapper.MapperProduct;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;

@Repository
public class ProductRepositoryJpa implements ProductRepository{
    private final SpringProductRepository springProductRepository;
    private final MapperProduct mapperProduct;

    public ProductRepositoryJpa(SpringProductRepository springProductRepository, MapperProduct mapperProduct){
        this.springProductRepository = springProductRepository;
        this.mapperProduct = mapperProduct;
    }

    @Override
    public Product create(Product product) {
        return save(product);
    }

    @Override
    public Optional<Product> findById(Long id){
        return springProductRepository.findById(id)
        .map(mapperProduct::toDomain);
    }

    @Override
    public Product save(Product product) {
        ProductEntity entity = mapperProduct.toEntity(product);
        ProductEntity saved = springProductRepository.save(entity);
        return mapperProduct.toDomain(saved);
    }

    @Override
    public void deleteById(Long id) {
        springProductRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return springProductRepository.findAll()
            .stream()
            .map(mapperProduct::toDomain)
            .toList();
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<ProductEntity> existingEntityOpt = springProductRepository.findById(id);
        if (existingEntityOpt.isPresent()) {
            ProductEntity existingEntity = existingEntityOpt.get();

            existingEntity.setNombre(product.getNombre());
            existingEntity.setPrecio(product.getPrecio());
            existingEntity.setStock(product.getStock());

            ProductEntity updatedEntity = springProductRepository.save(existingEntity);
            return mapperProduct.toDomain(updatedEntity);
        } else {
            throw new ProductNotFound("Producto con id " + id + "no encontrado");
        }
    }
}