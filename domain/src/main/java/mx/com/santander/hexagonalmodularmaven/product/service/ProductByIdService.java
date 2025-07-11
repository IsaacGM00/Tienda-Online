package mx.com.santander.hexagonalmodularmaven.product.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.port.dao.DaoProduct;

@RequiredArgsConstructor
public class ProductByIdService {
    private final DaoProduct daoProduct;

    public Product execute(long id){
        return daoProduct.getById(id);
    }
}