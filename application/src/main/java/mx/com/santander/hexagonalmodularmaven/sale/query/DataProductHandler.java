package mx.com.santander.hexagonalmodularmaven.sale.query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.sale.service.DataProductService;

@RequiredArgsConstructor
@Component

public class DataProductHandler {
    private final DataProductService dataProductService;

    public Product execute(Long id){
        return dataProductService.execute(id);
    }
}