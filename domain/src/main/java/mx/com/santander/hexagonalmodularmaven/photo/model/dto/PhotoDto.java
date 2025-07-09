package mx.com.santander.hexagonalmodularmaven.photo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhotoDto {
	private Long id;
	private Long albumId;
	private String title;
	private String url;
	private String thumbnailUrl;
}
