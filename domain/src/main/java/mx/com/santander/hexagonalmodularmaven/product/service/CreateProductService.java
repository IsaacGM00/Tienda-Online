package mx.com.santander.hexagonalmodularmaven.product.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.command.CreateProductCommand;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;

@RequiredArgsConstructor
public class CreateProductService {
    private final ProductRepository productRepository;

    public Product execute(CreateProductCommand createProductCommand){
        Product productToCreate = Product.fromCommand(createProductCommand);
        return productRepository.save(productToCreate);
    }
}