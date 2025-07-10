package mx.com.santander.hexagonalmodularmaven.client.adapter.mapper;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.client.adapter.entity.ClientEntity;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;


@Component
public class MapperClient {
    public Client toDomain(ClientEntity clientEntity){
        if(clientEntity == null){
            return null;
        }
        return new Client(
            clientEntity.getId(),
            clientEntity.getNombre(),
            clientEntity.getApellido(),
            clientEntity.getEmail(),
            clientEntity.getTelefono(),
            clientEntity.getDireccion()
        );
    }

    public ClientEntity toEntity(Client client){
        if(client == null){
            return null;
        }
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setNombre(client.getNombre());
        clientEntity.setApellido(client.getApellido());
        clientEntity.setEmail(client.getEmail());
        clientEntity.setTelefono(client.getTelefono());
        clientEntity.setDireccion(client.getDireccion());
        return clientEntity;
    }
}