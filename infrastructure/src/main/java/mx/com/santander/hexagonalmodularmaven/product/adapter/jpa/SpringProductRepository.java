package mx.com.santander.hexagonalmodularmaven.product.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import mx.com.santander.hexagonalmodularmaven.product.adapter.entity.ProductEntity;

@Repository
public interface SpringProductRepository extends JpaRepository<ProductEntity, Long>{
    ProductEntity getById(Long id);
    boolean existedByNombre(String nombre);
}