package mx.com.santander.hexagonalmodularmaven.sale.model.entity;

import jakarta.persistence.*;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.command.CreateSaleCommand;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Function;

@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    @OneToMany(mappedBy = "Sale", cascade = CascadeType.ALL)
    private List<DetailSale> detalles;

    private BigDecimal precioTotal;

    private LocalDateTime fechaCompra;

    public Sale() {}

    public Sale(Long id, Long clienteId, List<DetailSale> detalles, BigDecimal precioTotal, LocalDateTime fechaCompra) {
        this.id = id;
        this.clienteId = clienteId;
        this.detalles = detalles;
        this.precioTotal = precioTotal;
        this.fechaCompra = fechaCompra;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<DetailSale> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetailSale> detalles) {
        this.detalles = detalles;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public static Sale fromCommand(CreateSaleCommand command, Function<Long, Product> productFinder) {
        Sale sale = new Sale();
        sale.setClienteId(command.getClienteId());
        sale.setPrecioTotal(command.getPrecioTotal());
        sale.setFechaCompra(command.getFechaCompra());

        List<DetailSale> detalles = command.getDetalles().stream()
            .map(detailCommand -> {
             DetailSale detail = new DetailSale();
            detail.setProducto(productFinder.apply(detailCommand.getProductoId()));
            detail.setCantidad(detailCommand.getCantidad());
            detail.setPrecioUnitario(detailCommand.getPrecioUnitario());
            detail.setVenta(sale); // Relación bidireccional
            return detail;
        })

        .collect(Collectors.toList());
        sale.setDetalles(detalles);
        return sale;
    }

}