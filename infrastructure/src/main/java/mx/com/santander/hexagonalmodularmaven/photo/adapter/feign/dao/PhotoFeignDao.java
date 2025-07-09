package mx.com.santander.hexagonalmodularmaven.photo.adapter.feign.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import mx.com.santander.hexagonalmodularmaven.photo.adapter.entity.PhotoEntity;
import mx.com.santander.hexagonalmodularmaven.photo.adapter.feign.PhotoFeignAdapter;
import mx.com.santander.hexagonalmodularmaven.photo.adapter.mapper.PhotoDBMapper;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.dao.PhotoDao;

@Repository
public class PhotoFeignDao implements PhotoDao {
	
	private final PhotoDBMapper photoDbMapper;
	private final PhotoFeignAdapter photoFeignAdapter;
	
	PhotoFeignDao(PhotoDBMapper photoDbMapper, PhotoFeignAdapter photoFeignAdapter){
		this.photoDbMapper = photoDbMapper;
		this.photoFeignAdapter = photoFeignAdapter;
	}

	@Override
	public Photo getById(Long id) {
		final PhotoEntity photoEntity = photoFeignAdapter.getPhoto(id);
		return photoDbMapper.toDomain(photoEntity);
	}

	@Override
	public List<Photo> getAll() {
		List<PhotoEntity> photos = photoFeignAdapter.getPhotos();
		return photos.stream().map(photoDbMapper::toDomain).collect(Collectors.toList());
	}

}
