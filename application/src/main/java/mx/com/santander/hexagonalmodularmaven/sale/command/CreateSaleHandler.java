package mx.com.santander.hexagonalmodularmaven.sale.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.sale.mapper.SaleMapperDto;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.DtoSale;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.command.CreateSaleCommand;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;
import mx.com.santander.hexagonalmodularmaven.sale.service.CreateSaleService;

@Component
@RequiredArgsConstructor

public class CreateSaleHandler {
    private final CreateSaleService createSaleService;
    private final SaleMapperDto saleMapperDto;

    public DtoSale execute(CreateSaleCommand createSaleCommand){
        Sale sale = createSaleService.execute(createSaleCommand);
        return saleMapperDto.toDto(sale);
    }
}