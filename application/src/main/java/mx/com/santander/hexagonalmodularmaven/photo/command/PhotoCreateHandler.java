package mx.com.santander.hexagonalmodularmaven.photo.command;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.photo.mapper.PhotoDtoMapper;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.PhotoDto;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.command.PhotoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.photo.service.PhotoCreateService;

@Component
@RequiredArgsConstructor
public class PhotoCreateHandler {
	private final PhotoCreateService photoCreateService;
	private final PhotoDtoMapper photoDtoMapper;

	public PhotoDto execute(PhotoCreateCommand photoCreateCommand) {
		return photoDtoMapper.toDto(photoCreateService.execute(photoCreateCommand));
	}
}
