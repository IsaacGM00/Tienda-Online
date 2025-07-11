package mx.com.santander.hexagonalmodularmaven.sale.port.repository;

import java.util.List;
import java.util.Optional;

import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;

public interface SaleRepository {
    Optional<Sale> findById(Long id);
    Sale save(Sale sale);
    void deleteById(Long id);
    List<Sale> findAll();
    
    Sale update(Long id, Sale sale);
}