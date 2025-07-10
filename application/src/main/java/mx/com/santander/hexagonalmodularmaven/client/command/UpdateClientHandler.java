package mx.com.santander.hexagonalmodularmaven.client.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.mapper.ClientMapperDto;
import mx.com.santander.hexagonalmodularmaven.client.model.dto.DtoClient;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;
import mx.com.santander.hexagonalmodularmaven.client.service.UpdateClientService;

@Component
@RequiredArgsConstructor
public class UpdateClientHandler {

    private final ClientMapperDto clientMapperDto;
    private final UpdateClientService updateClientService;

    public DtoClient execute(Long id, Client updaClient){
        return clientMapperDto.toDto(updateClientService.execute(id, updaClient));
    }
}