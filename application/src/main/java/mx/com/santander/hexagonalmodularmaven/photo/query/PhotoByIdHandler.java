package mx.com.santander.hexagonalmodularmaven.photo.query;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.photo.mapper.PhotoDtoMapper;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.PhotoDto;
import mx.com.santander.hexagonalmodularmaven.photo.service.PhotoByIdService;

@Component
@RequiredArgsConstructor
public class PhotoByIdHandler {

	private final PhotoDtoMapper photoDtoMapper;
	private final PhotoByIdService photoByIdService;

	public PhotoDto execute(Long id) {
		return photoDtoMapper.toDto(photoByIdService.execute(id));
	}
}
