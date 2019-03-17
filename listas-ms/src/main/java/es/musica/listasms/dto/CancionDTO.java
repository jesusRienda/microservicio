package es.musica.listasms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CancionDTO {
	private Long trackId;
	private String name;
	private String gender;
	private String artist;
	private Integer duration;
	private String album;
}
