package mx.com.santander.hexagonalmodularmaven.photo.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.dao.PhotoDao;
@RequiredArgsConstructor
public class PhotoByIdService {

	private final PhotoDao photoDao;
	public Photo execute(Long id) {
		return photoDao.getById(id);
	}
}
