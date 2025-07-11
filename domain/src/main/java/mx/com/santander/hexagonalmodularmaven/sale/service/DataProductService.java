package mx.com.santander.hexagonalmodularmaven.sale.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.sale.port.dao.DaoProductData;

@RequiredArgsConstructor

public class DataProductService {
    private final DaoProductData daoProductData;
    public Product execute(Long id){
        return daoProductData.obtainData(id);
    }
}