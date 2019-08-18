package es.musica.listasms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancionDTO {
	
	private Long pos;
	private String artistName;
	private String trackUri;
	private String artistUri;
	private String trackName;
	private String albumUri;
	private Integer durationMs;
	private String albumName;
}
