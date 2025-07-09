package mx.com.santander.hexagonalmodularmaven.photo.adapter.mapper;

import org.springframework.stereotype.Component;

import mx.com.santander.hexagonalmodularmaven.photo.adapter.entity.PhotoEntity;
import mx.com.santander.hexagonalmodularmaven.photo.model.entity.Photo;

@Component
public class PhotoDBMapper {

	public PhotoEntity toDbo(Photo domain) {
		if (domain == null) {
			return null;
		}
		return new PhotoEntity(domain.getId(), domain.getAlbumId(), domain.getTitle(), domain.getUrl(),
				domain.getThumbnailUrl());
	}

	public Photo toDomain(PhotoEntity entity) {
		if (entity == null) {
			return null;
		}
		return new Photo(entity.getId(), entity.getAlbumId(), entity.getTitle(), entity.getUrl(),
				entity.getThumbnailUrl());
	}

	public PhotoEntity toDboCreate(Photo domain) {
		if(domain == null){
            return null;
        }
		return new PhotoEntity(domain.getAlbumId(),domain.getTitle(),domain.getUrl(),domain.getThumbnailUrl());
	}

}
