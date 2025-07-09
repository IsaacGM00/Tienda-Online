package mx.com.santander.hexagonalmodularmaven.photo.rest.controller;

import mx.com.santander.hexagonalmodularmaven.photo.model.dto.PhotoDto;
import mx.com.santander.hexagonalmodularmaven.photo.query.PhotoAllHandler;
import mx.com.santander.hexagonalmodularmaven.photo.query.PhotoByIdHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoQueryController {

	private final PhotoAllHandler photoAllHandler;
	private final PhotoByIdHandler photoByIdHandler;

	public PhotoQueryController(PhotoAllHandler photoAllHandler, PhotoByIdHandler photoByIdHandler) {
		this.photoAllHandler = photoAllHandler;
		this.photoByIdHandler = photoByIdHandler;
	}

	@GetMapping
	public List<PhotoDto> getAll() {
		return photoAllHandler.execute();
	}

	@GetMapping("/{id}")
	public PhotoDto getById(@PathVariable("id") long id) {
		return photoByIdHandler.execute(id);
	}
}
