package es.musica.listasms.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaDTO {
	private Long listId;
	private String name;
	private Integer numTracks;
	private Integer numArtists;
	private Integer duration;
	private List<CancionDTO> tracks;
}
