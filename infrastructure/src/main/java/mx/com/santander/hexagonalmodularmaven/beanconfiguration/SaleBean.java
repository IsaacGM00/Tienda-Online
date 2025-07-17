package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;
import mx.com.santander.hexagonalmodularmaven.sale.port.repository.SaleRepository;
import mx.com.santander.hexagonalmodularmaven.sale.service.CreateSaleService;

@Configuration
public class SaleBean {
    @Bean
    public CreateSaleService createSaleService(SaleRepository saleRepository, ProductRepository productRepository){
        return new CreateSaleService(saleRepository, productRepository);
    }
}