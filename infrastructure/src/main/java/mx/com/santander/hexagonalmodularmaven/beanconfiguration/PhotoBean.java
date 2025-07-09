package mx.com.santander.hexagonalmodularmaven.beanconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import mx.com.santander.hexagonalmodularmaven.photo.port.dao.PhotoDao;
import mx.com.santander.hexagonalmodularmaven.photo.port.repository.PhotoRepository;
import mx.com.santander.hexagonalmodularmaven.photo.service.PhotoAllService;
import mx.com.santander.hexagonalmodularmaven.photo.service.PhotoByIdService;
import mx.com.santander.hexagonalmodularmaven.photo.service.PhotoCreateService;

@Configuration
public class PhotoBean {
	
	@Bean
	public PhotoAllService photoAllService(PhotoDao photoDao) {
		return new PhotoAllService(photoDao);
	}
	
	@Bean
	public PhotoByIdService photoByIdService(PhotoDao photoDao) {
		return new PhotoByIdService(photoDao);
	}
	
	@Bean
	public PhotoCreateService photoCreateService(PhotoRepository photoRepository) {
		return new PhotoCreateService(photoRepository);
	}

}
