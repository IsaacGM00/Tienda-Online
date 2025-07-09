package mx.com.santander.hexagonalmodularmaven.client.query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.mapper.ClientMapperDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ClientHandler {
    private final ClientMapperDto clientMapperDto;
    private final ClientService clientService;

    public List<DtoClient> execute(){
        return clientService.excecute().stream().map(clientMapperDto::toDto).collect(Collectors.toList());
    }
}
