package mx.com.santander.hexagonalmodularmaven.product.port.dao;

import java.util.List;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

public interface DaoProduct {
    Product getById(Long id);
    List<Product> getAll();
}