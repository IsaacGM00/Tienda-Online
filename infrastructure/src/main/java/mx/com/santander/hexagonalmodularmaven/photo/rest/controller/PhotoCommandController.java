package mx.com.santander.hexagonalmodularmaven.photo.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.santander.hexagonalmodularmaven.photo.command.PhotoCreateHandler;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.PhotoDto;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.command.PhotoCreateCommand;

@RestController
@RequestMapping("/photos")
@RequiredArgsConstructor
public class PhotoCommandController {
	private final PhotoCreateHandler photoCreateHandler;

	@PostMapping()
	public PhotoDto create(@RequestBody PhotoCreateCommand photoCreateCommand) {
		return photoCreateHandler.execute(photoCreateCommand);
	}

}
