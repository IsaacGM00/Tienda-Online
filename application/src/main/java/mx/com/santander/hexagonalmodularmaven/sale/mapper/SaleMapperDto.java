package mx.com.santander.hexagonalmodularmaven.sale.mapper;

import org.mapstruct.Mapper;

import mx.com.santander.hexagonalmodularmaven.sale.model.dto.DtoSale;
import mx.com.santander.hexagonalmodularmaven.sale.model.entity.Sale;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface SaleMapperDto {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "clienteId", source = "clienteId")
    @Mapping(target = "detalles", source = "detalles")
    @Mapping(target = "precioTotal", source = "precioTotal")
    @Mapping(target = "fechaCompra", source = "fechaCompra")

    DtoSale toDto(Sale domain);
}