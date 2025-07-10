package mx.com.santander.hexagonalmodularmaven.client.command;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

import mx.com.santander.hexagonalmodularmaven.client.mapper.ClientMapperDto;
import mx.com.santander.hexagonalmodularmaven.client.service.CreateClientService;

import mx.com.santander.hexagonalmodularmaven.client.model.dto.DtoClient;
import mx.com.santander.hexagonalmodularmaven.client.model.dto.command.CreateClientCommand;

@Component
@RequiredArgsConstructor

public class CreateClientHandler {
    private final CreateClientService createClientService;
    private final ClientMapperDto clientMapperDto;

    public DtoClient excecute(CreateClientCommand createClientCommand){
        return clientMapperDto.toDto(createClientService.execute(createClientCommand));

    }
}