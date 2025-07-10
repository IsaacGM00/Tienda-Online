package mx.com.santander.hexagonalmodularmaven.product.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;

@RequiredArgsConstructor
public class UpdateProductService {
    private final ProductRepository productRepository;

    public Product execute(Long id, Product updateProduct){
        return productRepository.update(id, updateProduct);
    }
}