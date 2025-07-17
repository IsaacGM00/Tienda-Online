package mx.com.santander.hexagonalmodularmaven.sale.adapter.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sales")
@Getter
@Setter

public class SaleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Long clienteId;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;

    //Constructor
    @OneToMany(mappedBy = "sales",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<DetailSaleEntity> detalles;
}