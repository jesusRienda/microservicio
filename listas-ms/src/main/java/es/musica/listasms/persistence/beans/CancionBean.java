package es.musica.listasms.persistence.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancionBean {
	private Long pos;
	private String artist_name;
	private String track_uri;
	private String artist_uri;
	private String track_name;
	private String album_uri;
	private Integer duration_ms;
	private String album_name;
}
