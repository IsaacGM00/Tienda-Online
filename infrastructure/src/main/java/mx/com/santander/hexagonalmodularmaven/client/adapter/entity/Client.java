package mx.com.santander.hexagonalmodularmaven.client.adapter.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import mx.com.santander.hexagonalmodularmaven.client.model.dto.command.CreateClientCommand;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;

    // Getters y setters...

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Método para construir un Client desde un CreateClientCommand
    public static Client fromCommand(CreateClientCommand command) {
        Client client = new Client();
        client.setNombre(command.getNombre());
        client.setApellido(command.getApellido());
        client.setEmail(command.getEmail());
        client.setTelefono(command.getTelefono());
        client.setDireccion(command.getDireccion());
        return client;
    }
}