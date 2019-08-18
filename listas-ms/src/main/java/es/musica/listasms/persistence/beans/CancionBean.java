package es.musica.listasms.persistence.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancionBean {
	private Long pos;
	private String artistName;
	private String trackUri;
	private String artistUri;
	private String trackName;
	private String albumUri;
	private Integer durationMs;
	private String albumName;
}
