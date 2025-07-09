package mx.com.santander.hexagonalmodularmaven.photo.port.dao;

import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;

import java.util.List;

public interface PhotoDao {
	
    Photo getById(Long id);
    List<Photo> getAll();


}
