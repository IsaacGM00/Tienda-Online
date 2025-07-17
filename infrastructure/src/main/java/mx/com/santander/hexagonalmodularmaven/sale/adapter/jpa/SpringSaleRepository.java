package mx.com.santander.hexagonalmodularmaven.sale.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.sale.adapter.entity.SaleEntity;

@Repository
public interface SpringSaleRepository extends JpaRepository<SaleEntity, Long>{
    
}