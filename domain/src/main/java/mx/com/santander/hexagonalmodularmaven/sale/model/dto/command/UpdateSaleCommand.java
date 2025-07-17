package mx.com.santander.hexagonalmodularmaven.sale.model.dto.command;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.DtoProductSale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UpdateSaleCommand {
    private Long clienteId;
    private List<DtoProductSale> detalles;
    private BigDecimal precioTotal;
    private LocalDateTime fechaCompra;
}