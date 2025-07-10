package mx.com.santander.hexagonalmodularmaven.product.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.mapper.ProductMapperDto;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.DtoProduct;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.command.CreateProductCommand;
import mx.com.santander.hexagonalmodularmaven.product.service.CreateProductService;

@Component
@RequiredArgsConstructor

public class CreateProductHandler {
    private final CreateProductService createProductService;
    private final ProductMapperDto productMapperDto;

    public DtoProduct execute(CreateProductCommand createProductCommand){
        return productMapperDto.toDto(createProductService.execute(createProductCommand));
    }
}