package mx.com.santander.hexagonalmodularmaven.product.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.mapper.ProductMapperDto;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.DtoProduct;
import mx.com.santander.hexagonalmodularmaven.product.service.UpdateProductService;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

@Component
@RequiredArgsConstructor
public class UpdateProductHandler {
    
    private final ProductMapperDto productMapperDto;
    private final UpdateProductService updateProductService;

    public DtoProduct execute(Long id, Product updateProduct){
        return productMapperDto.toDto(updateProductService.execute(id, updateProduct));
    }
}