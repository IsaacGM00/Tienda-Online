package mx.com.santander.hexagonalmodularmaven.client.model.entity;

import lombok.NoArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.model.dto.command.CreateClientCommand;

@NoArgsConstructor
public class Client {

    private ClientId id;
    private ClientNombre nombre;
    private ClientApellido apellido;
    private ClientEmail email;
    private ClientTelefono telefono;
    private ClientDireccion direccion;

    // Constructor completo
    public Client(Long id, String nombre, String apellido, String email, String telefono, String direccion) {
        this.id = new ClientId(id);
        this.nombre = new ClientNombre(nombre);
        this.apellido = new ClientApellido(apellido);
        this.email = new ClientEmail(email);
        this.telefono = new ClientTelefono(telefono);
        this.direccion = new ClientDireccion(direccion);
    }

    public Client requestToCreateClient(CreateClientCommand createClientCommand){
        this.nombre = new ClientNombre(createClientCommand.getNombre());
        this.apellido = new ClientApellido(createClientCommand.getApellido());
        this.email = new ClientEmail(createClientCommand.getEmail());
        this.telefono = new ClientTelefono(createClientCommand.getTelefono());
        this.direccion = new ClientDireccion(createClientCommand.getDireccion());
        return this;
    }

    // Getters
    public Long getId() { return id.getId(); }

    public String getNombre() { return nombre.getNombre(); }

    public String getApellido() { return apellido.getApellido(); }

    public String getEmail() { return email.getEmail(); }

    public String getTelefono() { return telefono.getTelefono(); }

    public String getDireccion() { return direccion.getDireccion(); }

}