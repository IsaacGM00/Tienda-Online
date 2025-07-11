package mx.com.santander.hexagonalmodularmaven.sale.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.command.CreateSaleCommand;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;
import mx.com.santander.hexagonalmodularmaven.sale.port.repository.SaleRepository;

@RequiredArgsConstructor
public class CreateSaleService {
    private final SaleRepository saleRepository;

    public Sale execute(CreateSaleCommand createSaleCommand){
        Sale saleToCreate = Sale.fromCommand(createSaleCommand);
        return saleRepository.save(saleToCreate);
    }
}