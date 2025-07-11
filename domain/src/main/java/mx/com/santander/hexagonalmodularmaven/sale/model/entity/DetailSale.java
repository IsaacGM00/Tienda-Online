package mx.com.santander.hexagonalmodularmaven.sale.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

@Entity
@Table(name = "detail_sale")
public class DetailSale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

     private Long id;

    @ManyToOne
    @JoinColumn(name = "ventaId")
    private Sale venta;

    @ManyToOne
    @JoinColumn(name="productoId")
    private Product producto;

    private Integer cantidad;
    private Double precioUnitario;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Sale getVenta() {
        return venta;
    }
    public void setVenta(Sale venta) {
        this.venta = venta;
    }
    public Product getProducto() {
        return producto;
    }
    public void setProducto(Product producto) {
        this.producto = producto;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public Double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}