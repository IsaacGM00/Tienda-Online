package mx.com.santander.hexagonalmodularmaven.client.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.santander.hexagonalmodularmaven.client.model.dto.DtoClient;
import mx.com.santander.hexagonalmodularmaven.client.query.ClientByIdHandler;
import mx.com.santander.hexagonalmodularmaven.client.query.ClientHandler;

@RequestMapping("api/clients")
@RestController

public class ControllerClientQuery {
    private final ClientHandler clientHandler;
    private final ClientByIdHandler clientByIdHandler;

    public ControllerClientQuery(ClientHandler clientHandler, ClientByIdHandler clientByIdHandler){
        this.clientHandler = clientHandler;
        this.clientByIdHandler = clientByIdHandler;
    }

    @GetMapping("{id}")
    public DtoClient getByIdClient(@PathVariable("id") Long id){
        return clientByIdHandler.execute(id);
    }

    @GetMapping
    public List<DtoClient> getAllClients(){
        return clientHandler.execute();
    }
}