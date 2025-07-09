package mx.com.santander.hexagonalmodularmaven.photo.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhotoEntity {
	private Long id;
	private Long albumId;
	private String title;
	private String url;
	private String thumbnailUrl;
	
	public PhotoEntity(Long albumId, String title, String url, String thumbnailUrl){
		this.albumId = albumId;
		this.title = title;
		this.url = url;
		this.thumbnailUrl = thumbnailUrl;
	}
}
