package mx.com.santander.hexagonalmodularmaven.sale.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import mx.com.santander.hexagonalmodularmaven.sale.model.entity.DetailSale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DtoSale {
    private Long id;
    private Long clienteId;
    private List<DetailSale> detalles;
    private double precioTotal;
    private LocalDateTime fechaCompra;
}