package mx.com.santander.hexagonalmodularmaven.product.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DtoProduct {
    private Long id;
    private String nombre;
    private Double precio;
}