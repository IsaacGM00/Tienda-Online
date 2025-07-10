package mx.com.santander.hexagonalmodularmaven.client.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.santander.hexagonalmodularmaven.client.command.CreateClientHandler;
import mx.com.santander.hexagonalmodularmaven.client.command.DeleteClientHandler;
import mx.com.santander.hexagonalmodularmaven.client.command.UpdateClientHandler;
import mx.com.santander.hexagonalmodularmaven.client.model.dto.DtoClient;
import mx.com.santander.hexagonalmodularmaven.client.model.dto.command.CreateClientCommand;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;

@RequestMapping("api/clients")
@RestController
public class ControllerClientCommand {
    private final CreateClientHandler createClientHandler;
    private final DeleteClientHandler deleteClientHandler;
    private final UpdateClientHandler updateClientHandler;

    public ControllerClientCommand(CreateClientHandler createClientHandler, 
    DeleteClientHandler deleteClientHandler, UpdateClientHandler updateClientHandler){
        this.createClientHandler = createClientHandler;
        this.deleteClientHandler = deleteClientHandler;
        this.updateClientHandler = updateClientHandler;
    }

    @PostMapping
    public DtoClient addClient(@RequestBody CreateClientCommand createClientCommand){
        return createClientHandler.execute(createClientCommand);
    }

    @DeleteMapping("{id}")
    public void deleteClient(@PathVariable("id") Long id){
        deleteClientHandler.execute(id);
    }

    @PutMapping("{id}")
    public DtoClient updaDtoClient(@PathVariable("id") Long id, @RequestBody Client updateClient){
        return updateClientHandler.execute(id, updateClient);
    }
}