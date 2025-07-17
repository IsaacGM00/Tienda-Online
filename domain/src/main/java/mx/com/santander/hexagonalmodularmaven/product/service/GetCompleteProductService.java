package mx.com.santander.hexagonalmodularmaven.product.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.port.dao.DaoProduct;

@RequiredArgsConstructor
public class GetCompleteProductService {

    private final DaoProduct daoProduct;

    public List<Product> execute(){
        return daoProduct.getAll();
    }
}