package es.musica.listasms.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListaDTO {
	private Long listId;
	private String name;
	private Boolean collaborative;
	private Integer pid;
	private Integer modifiedAt;
	private Integer numTracks;
	private Integer numAlbums;
	private Integer numFollowers;
	private Integer numEdits;
	private Integer durationMs;
	private Integer numArtists;
	private List<CancionDTO> tracks;
}
