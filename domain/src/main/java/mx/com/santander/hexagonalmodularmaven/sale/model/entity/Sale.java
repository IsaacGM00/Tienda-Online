package mx.com.santander.hexagonalmodularmaven.sale.model.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;

@Entity
@Table(name="sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Client cliente;

    @OneToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private List<DetailSale> detalles;

    private Double precioTotal;
    private LocalDateTime fechaCompra;

    // Constructor completo
    public Sale(Long id, Client cliente, List<DetailSale> detalles, Double precioTotal, 
    LocalDateTime fechaCompra) {
        this.id = id;
        this.cliente = cliente;
        this.detalles = detalles;
        this.precioTotal = precioTotal;
        this.fechaCompra = fechaCompra;
    }

    // Constructor vacío (requerido por JPA)
    public Sale() {}

    // Getters y setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Client getClient() {
        return cliente;
    }
    public void setClient(Client cliente) {
        this.cliente = cliente;
    }
    public List<DetailSale> getDetalles() {
        return detalles;
    }
    public void setDetalles(List<DetailSale> detalles) {
        this.detalles = detalles;
    }
    public Double getPrecioTotal() {
        return precioTotal;
    }
    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }
    public LocalDateTime getFechaCompra() {
        return fechaCompra;
    }
    public void setFechaCompra(LocalDateTime fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    // Método para construir desde un comando
    public static Sale fromCommand(Client cliente, List<DetailSale> detalles, Double precioTotal) {
        Sale sale = new Sale();
        sale.setClient(cliente); // Este cliente debe ser buscado previamente por el clienteId
        sale.setDetalles(detalles); // Convertidos desde DtoProductSale
        sale.setPrecioTotal(precioTotal);
        sale.setFechaCompra(LocalDateTime.now()); 
        return sale;
    }
}