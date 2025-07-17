package mx.com.santander.hexagonalmodularmaven.product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import mx.com.santander.hexagonalmodularmaven.product.model.dto.command.CreateProductCommand;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;
import mx.com.santander.hexagonalmodularmaven.product.service.CreateProductService;

@ExtendWith(MockitoExtension.class)

class CreateProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CreateProductService createProductService;

    @Test
    void createProductTest() {
        CreateProductCommand command = new CreateProductCommand("Xbox360", 15604.32, 40);
        Product savedProduct = new Product(1L, "Xbox360", 15604.32, 40);

        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);
        Product resultProduct = createProductService.execute(command);

        assertEquals(1L, resultProduct.getId());
    }
}