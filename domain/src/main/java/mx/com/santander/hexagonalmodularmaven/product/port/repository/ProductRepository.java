package mx.com.santander.hexagonalmodularmaven.product.port.repository;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
    List<Product> findAll();
    
    Product update(Long id, Product product);
}