package es.musica.listasms.persistence.beans;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancionBean {
	private Long trackId;
	private String name;
	private String gender;
	private String artist;
	private Integer duration;
	private String album;
}
