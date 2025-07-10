package mx.com.santander.hexagonalmodularmaven.product.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateProductCommand {
    private String nombre;
    private Double precio;
    private Integer stock;
}