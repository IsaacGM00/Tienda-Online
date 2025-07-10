package mx.com.santander.hexagonalmodularmaven.product.port.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}