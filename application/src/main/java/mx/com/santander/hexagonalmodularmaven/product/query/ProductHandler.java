package mx.com.santander.hexagonalmodularmaven.product.query;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.mapper.ProductMapperDto;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.DtoProduct;
import mx.com.santander.hexagonalmodularmaven.product.service.ProductService;

@Component
@RequiredArgsConstructor
public class ProductHandler {
    private final ProductMapperDto productMapperDto;
    private final ProductService productService;

    public List<DtoProduct> execute(){
        return productService.getAllProducts().stream()
        .map(productMapperDto::toDto)
        .collect(Collectors.toList());
    }
}