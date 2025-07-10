package mx.com.santander.hexagonalmodularmaven.client.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import mx.com.santander.hexagonalmodularmaven.client.model.dto.DtoClient;
import mx.com.santander.hexagonalmodularmaven.client.model.entity.Client;

@Mapper(componentModel = "spring")

public interface ClientMapperDto {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "apellido", source = "apellido")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telefono", source = "telefono")
    @Mapping(target = "direccion", source = "direccion")

    DtoClient toDto(Client domain);
}