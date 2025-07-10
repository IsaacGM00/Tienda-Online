package mx.com.santander.hexagonalmodularmaven.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import mx.com.santander.hexagonalmodularmaven.product.model.dto.DtoProduct;
import mx.com.santander.hexagonalmodularmaven.product.model.entity.Product;

@Mapper(componentModel = "spring")

public interface ProductMapperDto {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "nombre", source = "nombre")
    @Mapping(target = "precio", source = "precio")

    DtoProduct toDto(Product domain);
}