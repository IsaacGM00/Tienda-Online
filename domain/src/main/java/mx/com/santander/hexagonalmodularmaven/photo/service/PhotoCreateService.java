package mx.com.santander.hexagonalmodularmaven.photo.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.command.PhotoCreateCommand;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.repository.PhotoRepository;

@RequiredArgsConstructor
public class PhotoCreateService {

	private final PhotoRepository photoRepository;

	public Photo execute(PhotoCreateCommand photoCreateCommand) {
		Photo photoToCreate = new Photo().requestToCreate(photoCreateCommand);
		return photoRepository.create(photoToCreate);
	}
}
