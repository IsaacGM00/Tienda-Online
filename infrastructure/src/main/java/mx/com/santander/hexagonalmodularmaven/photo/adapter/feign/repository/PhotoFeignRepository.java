package mx.com.santander.hexagonalmodularmaven.photo.adapter.feign.repository;

import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.photo.adapter.feign.PhotoFeignAdapter;
import mx.com.santander.hexagonalmodularmaven.photo.adapter.mapper.PhotoDBMapper;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;
import mx.com.santander.hexagonalmodularmaven.photo.port.repository.PhotoRepository;

@Repository
@Transactional
@RequiredArgsConstructor
public class PhotoFeignRepository implements PhotoRepository {
	
	private final PhotoFeignAdapter photoFeignAdapter;
	private final PhotoDBMapper photoDbMapper;
	
	@Override
	public Photo create(Photo photo) {
		var photoToSave = photoDbMapper.toDboCreate(photo);
		var photoSaved = photoFeignAdapter.create(photoToSave);
		return photoDbMapper.toDomain(photoSaved);
	}

}
