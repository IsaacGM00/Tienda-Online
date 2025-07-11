import java.util.Collections;

import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.product.port.dao.DaoProduct;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.command.CreateSaleCommand;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.DetailSale;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;
import mx.com.santander.hexagonalmodularmaven.sale.port.repository.SaleRepository;
import mx.com.santander.hexagonalmodularmaven.sale.service.CreateSaleService;

@ExtendWith(MockitoExtension.class)
public class CreateSaleServiceTest {
    @Mock
    private SaleRepository saleRepository;

    @Mock
    private DaoProduct daoProduct;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private CreateSaleService createSaleService;

    @BeforeEach
    void testSale(){
        saleRepository = mock(SaleRepository.class);
        daoProduct = mock(DaoProduct.class);
        productRepository = mock(ProductRepository.class);
        createSaleService = new CreateSaleService(saleRepository, productRepository, daoProduct);
    }

    @Test
    void buyAndUpdateStock(){
        CreateSaleCommand createSaleCommand = new CreateSaleCommand();
        Sale sale = new Sale();
        DetailSale detailSale = new DetailSale();

        detailSale.setId(1);
        detailSale.setCantidad(2);
        sale.setDetalles(Collections.singletonList(detailSale));

        Product product = new Product(1, "XboxOne", 16544.95, 27);

        when(daoProduct.getById(1)).thenReturn(product);

        Sale resultSale = createSaleService.execute(createSaleCommand);
        assertNotNull(resultSale);
        verify(productRepository).update(any(Product.class));
    }
}