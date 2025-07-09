package mx.com.santander.hexagonalmodularmaven.client.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.mapper.ClientMapperDto;

@Component
@RequiredArgsConstructor
public class CreateClientHandler {

    private final CreateClientService createClientService;
    private final ClientMapperDto clientMapperDto;

    public DtoClient excecute(CreateClientCommand createClientCommand){
        return clienteMapperDto.toDto(createClientService.excecute(createClientCommand));
    }
}
