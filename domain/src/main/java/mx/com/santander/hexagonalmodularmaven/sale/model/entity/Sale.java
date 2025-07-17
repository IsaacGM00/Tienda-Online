package mx.com.santander.hexagonalmodularmaven.sale.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

public class Sale {
    private Long id;
    private Long clienteId;
    private List<DetailSale> detalles;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;
}