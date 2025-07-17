package mx.com.santander.hexagonalmodularmaven.sale.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.command.CreateSaleCommand;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.DetailSale;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;
import mx.com.santander.hexagonalmodularmaven.sale.port.repository.SaleRepository;
import mx.com.santander.hexagonalmodularmaven.product.port.repository.ProductRepository;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class CreateSaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    public Sale execute(CreateSaleCommand createSaleCommand) {
        List<DetailSale> detalles = createSaleCommand.getDetalles().stream()
            .map(productoCommand -> {
                Product producto = productRepository.findById(productoCommand.getProductoId())
                    .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

                DetailSale detalle = new DetailSale();
                detalle.setProductoId(producto.getId());
                detalle.setNombre(producto.getNombre());
                detalle.setPrecioUnitario(BigDecimal.valueOf(producto.getPrecio()));
                detalle.setCantidad(productoCommand.getCantidad());
                return detalle;
            })
            .toList();

        BigDecimal total = detalles.stream()
            .map(d -> d.getPrecioUnitario().multiply(BigDecimal.valueOf(d.getCantidad())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        Sale sale = new Sale();
        sale.setClienteId(createSaleCommand.getClienteId());
        sale.setDetalles(detalles);
        sale.setPrecioTotal(total);
        sale.setFechaCompra(LocalDateTime.now());

        return saleRepository.save(sale);
    }
}