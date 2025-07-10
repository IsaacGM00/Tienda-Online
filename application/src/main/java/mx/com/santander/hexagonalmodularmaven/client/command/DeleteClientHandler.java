package mx.com.santander.hexagonalmodularmaven.client.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.service.DeleteClientService;

@Component
@RequiredArgsConstructor
public class DeleteClientHandler {

    private final DeleteClientService deleteClientService;

    public void execute(Long id){
        deleteClientService.execute(id);
    }
}