package mx.com.santander.hexagonalmodularmaven.client.query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.client.mapper.ClientMapperDto;
import mx.com.santander.hexagonalmodularmaven.client.model.dto.DtoClient;
import mx.com.santander.hexagonalmodularmaven.client.service.ClientByIdservice;

@RequiredArgsConstructor
@Component
public class ClientByIdHandler {
    
    private final ClientMapperDto clientMapperDto;
    private final ClientByIdservice clientByIdservice;

    public DtoClient execute(Long id){
        return clientMapperDto.toDto(clientByIdservice.execute(id));
    }
}