package mx.com.santander.hexagonalmodularmaven.photo.model.dto.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PhotoCreateCommand {
	
	private Long albumId;
	private String title;
	private String url;
	private String thumbnailUrl;

}
