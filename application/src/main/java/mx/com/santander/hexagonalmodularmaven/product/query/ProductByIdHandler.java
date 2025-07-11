package mx.com.santander.hexagonalmodularmaven.product.query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.mapper.ProductMapperDto;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.DtoProduct;
import mx.com.santander.hexagonalmodularmaven.product.service.ProductByIdService;

@RequiredArgsConstructor
@Component
public class ProductByIdHandler {
    private final ProductMapperDto productMapperDto;
    private final ProductByIdService productByIdService;

    public DtoProduct execute(Long id){
        return productMapperDto.toDto(productByIdService.execute(id));
    }
}