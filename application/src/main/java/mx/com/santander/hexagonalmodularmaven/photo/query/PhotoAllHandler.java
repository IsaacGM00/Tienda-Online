package mx.com.santander.hexagonalmodularmaven.photo.query;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.photo.mapper.PhotoDtoMapper;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.PhotoDto;
import mx.com.santander.hexagonalmodularmaven.photo.service.PhotoAllService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PhotoAllHandler {

	private final PhotoAllService photoAllService;
	private final PhotoDtoMapper photoDtoMapper;

	public List<PhotoDto> execute() {
		return photoAllService.execute().stream().map(photoDtoMapper::toDto).collect(Collectors.toList());
	}

}
