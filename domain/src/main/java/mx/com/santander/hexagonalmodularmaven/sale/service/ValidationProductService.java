package mx.com.santander.hexagonalmodularmaven.sale.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.sale.port.dao.DaoProductValidation;

@RequiredArgsConstructor

public class ValidationProductService {
    private final DaoProductValidation daoProductValidation;

    public boolean execute(Long id){
        return daoProductValidation.existingProduct(id);
    }
    
}