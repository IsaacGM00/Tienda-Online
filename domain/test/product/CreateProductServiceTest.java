import org.hibernate.annotations.TimeZoneStorage;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;
import mx.com.santander.hexagonalmodularmaven.product.service.CreateProductService;

@ExtendWith(MockitoExtension.class)
public class CreateProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CreateProductService createProductService;

    @Test
    void createProductTest(){
        Product product = new Product(null, "PlaySation5", 14678.65, 14678.65);
        Product saveProduct = new Product(1, "PlaySation5", 14678.65, 30);

        when(productRepository.save(product)).thenReturn(saveProduct);
        Product resultProduct = createProductService.execute(product);

        assertEquals(1L, resultProduct.getId());
    }
}