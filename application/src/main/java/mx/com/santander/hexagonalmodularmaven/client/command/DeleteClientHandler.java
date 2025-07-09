package mx.com.santander.hexagonalmodularmaven.client.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.mapper.ClientMapperDto;

@Component
@RequiredArgsConstructor
public class DeleteClientHandler {

    private final ClientMapperDto clientMapperDto;
    private final DeleteClientService deleteClientService;

    public void execute(Long id){
        deleteClientService.excecute(id);
    }
}
