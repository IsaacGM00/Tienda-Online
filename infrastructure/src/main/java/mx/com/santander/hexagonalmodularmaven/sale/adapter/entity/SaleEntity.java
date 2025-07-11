package mx.com.santander.hexagonalmodularmaven.sale.adapter.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;

import mx.com.santander.hexagonalmodularmaven.sale.model.entity.DetailSale;

@Entity
@Table(name = "sales")

public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long clienteId;

    @OneToMany(mappedBy = "Sale", cascade = CascadeType.ALL)
    private List<DetailSale> detalles;

    private BigDecimal precioTotal;

    private LocalDateTime fechaCompra;

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
}