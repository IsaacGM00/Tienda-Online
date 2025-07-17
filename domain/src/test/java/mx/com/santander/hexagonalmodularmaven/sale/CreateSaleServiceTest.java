package mx.com.santander.hexagonalmodularmaven.sale;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.port.dao.DaoProduct;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.command.CreateSaleCommand;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.DetailSale;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;
import mx.com.santander.hexagonalmodularmaven.sale.port.repository.SaleRepository;
import mx.com.santander.hexagonalmodularmaven.sale.service.CreateSaleService;

@ExtendWith(MockitoExtension.class)
class CreateSaleServiceTest {

    @Mock
    private SaleRepository saleRepository;

    @Mock
    private DaoProduct daoProduct;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CreateSaleService createSaleService;

    @Test
    void buyAndUpdateStock() {
        CreateSaleCommand createSaleCommand = new CreateSaleCommand();
        Sale sale = new Sale();
        DetailSale detailSale = new DetailSale();

        detailSale.setProductoId(1L);
        detailSale.setCantidad(2);
        sale.setDetalles(Collections.singletonList(detailSale));

        Product product = new Product(1L, "Xbox360", 15604.32, 40);

        when(daoProduct.getById(1L)).thenReturn(product);
        when(saleRepository.save(any(Sale.class))).thenReturn(sale);

        Sale resultSale = createSaleService.execute(createSaleCommand);

        assertNotNull(resultSale);
        verify(productRepository).update(product.getId(), product);
    }
}