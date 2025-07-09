package mx.com.santander.hexagonalmodularmaven.photo.model.entity;

import lombok.NoArgsConstructor;
import mx.com.santander.hexagonalmodularmaven.photo.model.dto.command.PhotoCreateCommand;

@NoArgsConstructor
public class Photo {

	private PhotoId id;
	private PhotoAlbumId albumId;
	private PhotoTitle title;
	private PhotoUrl url;
	private PhotoThumbnailUrl thumbnailUrl;
	
	public Photo(Long id, Long albumId, String title, String url, String thumbnailUrl) {
		this.id = new PhotoId(id);
		this.albumId = new PhotoAlbumId(albumId);
		this.title = new PhotoTitle(title);
		this.url = new PhotoUrl(url);
		this.thumbnailUrl = new PhotoThumbnailUrl(thumbnailUrl);
	}
	
	public Photo requestToCreate(PhotoCreateCommand photoCreateCommand) {
		this.albumId = new PhotoAlbumId(photoCreateCommand.getAlbumId());
		this.thumbnailUrl = new PhotoThumbnailUrl(photoCreateCommand.getThumbnailUrl());
		this.title = new PhotoTitle(photoCreateCommand.getTitle());
		this.url = new PhotoUrl(photoCreateCommand.getUrl());
		return this;
	}

	public Long getId() {
		return id.getId();
	}

	public Long getAlbumId() {
		return albumId.getAlbumId();
	}


	public String getTitle() {
		return title.getTitle();
	}

	public String getUrl() {
		return url.getUrl();
	}

	public String getThumbnailUrl() {
		return thumbnailUrl.getThumbnailUrl();
	}

	
	
}
