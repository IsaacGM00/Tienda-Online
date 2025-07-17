package mx.com.santander.hexagonalmodularmaven.product.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.product.model.dto.command.CreateProductCommand;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.port.message.ProductKafkaProducer;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;

@RequiredArgsConstructor
public class CreateProductService {
    private final ProductRepository productRepository;
    private final ProductKafkaProducer productKafkaProducer;

    public Product execute(CreateProductCommand createProductCommand){
        Product productToCreate = new Product().requestToCreateProduct(createProductCommand);
        Product productCreated = productRepository.create(productToCreate); // usa la instancia
        productKafkaProducer.mensajeProductoCreado(productCreated); // usa la instancia
        return productCreated;
    }

}