package mx.com.santander.hexagonalmodularmaven.sale.query;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.sale.service.ValidationProductService;

@RequiredArgsConstructor

public class ValidationProductHandler {
    private final ValidationProductService validationProductService;

    public boolean execute(Long id){
        return validationProductService.execute(id);
    }
}