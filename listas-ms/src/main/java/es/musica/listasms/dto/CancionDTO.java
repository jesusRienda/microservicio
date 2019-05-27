package es.musica.listasms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancionDTO {
	
	private Long pos;
	private String artist_name;
	private String track_uri;
	private String artist_uri;
	private String track_name;
	private String album_uri;
	private Integer duration_ms;
	private String album_name;
}
