package mx.com.santander.hexagonalmodularmaven.sale.model.entity;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DetailSale {
    private Long productoId;
    private String nombre;
    private int cantidad;
    private BigDecimal precioUnitario;
}