package mx.com.santander.hexagonalmodularmaven.sale.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DtoProductSale {
    private Long productoId;
    private Integer cantidad;
}