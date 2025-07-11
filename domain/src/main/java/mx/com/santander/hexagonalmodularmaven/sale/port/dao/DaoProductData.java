package mx.com.santander.hexagonalmodularmaven.sale.port.dao;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

public interface DaoProductData {
    Product obtainData(Long id);
}