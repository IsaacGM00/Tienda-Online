package mx.com.santander.hexagonalmodularmaven.sale.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.command.CreateSaleCommand;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;
import mx.com.santander.hexagonalmodularmaven.sale.port.repository.SaleRepository;

import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;

@RequiredArgsConstructor
public class CreateSaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    public Sale execute(CreateSaleCommand createSaleCommand){
        Sale saleToCreate = Sale.fromCommand(
            createSaleCommand,
            productId -> productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Producto no encontrado"))
        );
        return saleRepository.save(saleToCreate);
    }
}