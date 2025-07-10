package mx.com.santander.hexagonalmodularmaven.product.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;

@RequiredArgsConstructor
public class DeleteProductService {
    
    private final ProductRepository productRepository;

    public void execute(Long id){
        productRepository.deleteById(id);
    }
}