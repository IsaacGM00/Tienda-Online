package mx.com.santander.hexagonalmodularmaven.photo.service;

import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.dao.PhotoDao;

import java.util.List;
@RequiredArgsConstructor
public class PhotoAllService {
	private final PhotoDao photoDao;
	public List<Photo> execute(){
		return photoDao.getAll();
	}
}
