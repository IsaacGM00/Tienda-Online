package mx.com.santander.hexagonalmodularmaven.photo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.photo.model.dto.PhotoDto;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;

@Mapper(componentModel = "spring")
@Component
public interface PhotoDtoMapper {

	@Mapping(source = "id", target = "id")
	@Mapping(source = "albumId", target = "albumId")
	@Mapping(source = "title", target = "title")
	@Mapping(source = "url", target = "url")
	@Mapping(source = "thumbnailUrl", target = "thumbnailUrl")
	PhotoDto toDto(Photo domain);
}
