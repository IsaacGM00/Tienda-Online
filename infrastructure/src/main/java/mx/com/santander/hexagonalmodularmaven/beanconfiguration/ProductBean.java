package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.product.port.dao.DaoProduct;
import mx.com.santander.hexagonalmodularmaven.product.port.message.ProductKafkaProducer;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;
import mx.com.santander.hexagonalmodularmaven.product.service.CreateProductService;
import mx.com.santander.hexagonalmodularmaven.product.service.DeleteProductService;
import mx.com.santander.hexagonalmodularmaven.product.service.GetCompleteProductService;
import mx.com.santander.hexagonalmodularmaven.product.service.ProductByIdService;
import mx.com.santander.hexagonalmodularmaven.product.service.UpdateProductService;

@Configuration
public class ProductBean {
    @Bean
    public GetCompleteProductService getCompleteProductService(DaoProduct daoProduct){
        return new GetCompleteProductService(daoProduct);
    }

    @Bean
    public ProductByIdService productByIdService(DaoProduct daoProduct){
        return new ProductByIdService(daoProduct);
    }

    @Bean
    public CreateProductService createProductService(ProductRepository productRepository, ProductKafkaProducer productKafkaProducer){
        return new CreateProductService(productRepository, productKafkaProducer);
    }

    @Bean
    public UpdateProductService updateProductService(ProductRepository productRepository){
        return new UpdateProductService(productRepository);
    }

    @Bean
    public DeleteProductService deleteProductService(ProductRepository productRepository){
        return new DeleteProductService(productRepository);
    }
    
}