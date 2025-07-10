package mx.com.santander.hexagonalmodularmaven.client.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CreateClientCommand {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
}
