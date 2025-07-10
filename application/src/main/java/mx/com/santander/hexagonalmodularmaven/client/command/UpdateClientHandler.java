package mx.com.santander.hexagonalmodularmaven.client.command;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.mapper.ClientMapperDto;

@Component
@RequiredArgsConstructor
public class UpdateClientHandler {
    private final ClientMapperDto clientMapperDto;
    
}
