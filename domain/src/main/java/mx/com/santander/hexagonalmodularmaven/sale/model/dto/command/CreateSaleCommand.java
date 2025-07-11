package mx.com.santander.hexagonalmodularmaven.sale.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import mx.com.santander.hexagonalmodularmaven.sale.model.dto.DtoProductSale;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateSaleCommand {
    private Long clienteId;
    private List<DtoProductSale> productos;
}